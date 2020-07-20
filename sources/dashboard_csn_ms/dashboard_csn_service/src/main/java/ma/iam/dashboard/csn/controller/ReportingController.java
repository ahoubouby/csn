package ma.iam.dashboard.csn.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import ma.iam.dashboard.csn.dtos.ReportingDto;
import ma.iam.dashboard.csn.services.IReportingService;
import ma.iam.dashboard.csn.utils.DateUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author  K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
@RestController
@RequestMapping("/services/report")
public class ReportingController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final String JASPER_FILE_EQUIPEMENT = "equipement.jasper";
	
	@Autowired
	private IReportingService reportingService;
	
	@RequestMapping("/equipement.xls")
	public void renderXlsEquipementFrais(
			@RequestParam(value = "dr") String dr,
			@RequestParam(value = "dc") String dc,
			@RequestParam(value = "technologie") String technologie,
			@RequestParam(value = "infrastructure") String infrastructure,
			OutputStream out, HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel");
		String dateExport = DateUtils.dateTimeFrTiretToString(new Date());
		response.setHeader("Content-Disposition", "attachment; filename=equipement" + dateExport + ".xls");
		renderExportEquipement(dr, dc, technologie, infrastructure, out, "xls");
	}
	
	@RequestMapping("/equipement.pdf")
	public void renderPdfEquipementFrais(
			@RequestParam(value = "dr") String dr,
			@RequestParam(value = "dc") String dc,
			@RequestParam(value = "technologie") String technologie,
			@RequestParam(value = "infrastructure") String infrastructure,
			OutputStream out,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf;charset=UTF-8");
		String dateExport = DateUtils.dateTimeFrTiretToString(new Date());
		response.setHeader("Content-Disposition", "inline; filename=equipement"+ dateExport +".pdf");
		renderExportEquipement(dr, dc, technologie, infrastructure, out, "pdf");
	}

	private void renderExportEquipement(String dr, String dc, String technologie, String infrastructure, OutputStream out, String fileType) throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		// Recuperation des donnees
		List<ReportingDto> listResultats = reportingService.getListEquipementReportingByCriteres(dr, dc, technologie, infrastructure);
		//

		try {
			if ("xls".equalsIgnoreCase(fileType)) {
				if (listResultats == null){
					listResultats = new ArrayList<ReportingDto>();
				}
				out.write(generateXls(JASPER_FILE_EQUIPEMENT, listResultats, parameters));
			}
			else if ("pdf".equalsIgnoreCase(fileType)) {
				if (listResultats == null){
					listResultats = new ArrayList<ReportingDto>();
				}
				out.write(generatePdf(JASPER_FILE_EQUIPEMENT, listResultats, parameters));
			}
		} catch (Exception e) {
			logger.error("Erreur lors de la generation de l'export des equipements : ", e);
			throw e;
		}
	}
	
	
	
	public byte[] generateXls(String report, List<?> datas, Map<String, Object> parameters) throws JRException {

        InputStream stream = null ;
        JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(datas);
		JasperPrint jasperPrint= null;
		ByteArrayOutputStream outputByteArray = new ByteArrayOutputStream();
		try{
			
			stream = new ClassPathResource(report).getInputStream();
			if(stream != null){
				jasperPrint = JasperFillManager.fillReport(stream, parameters, jrBeanCollectionDataSource);
				
				JRXlsExporter xlsExporter = new JRXlsExporter();
                xlsExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                xlsExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputByteArray));
                
                SimpleXlsReportConfiguration xlsReportConfiguration = new SimpleXlsReportConfiguration();
                xlsReportConfiguration.setOnePagePerSheet(false);
                xlsReportConfiguration.setRemoveEmptySpaceBetweenRows(true);
                xlsReportConfiguration.setDetectCellType(true);
                xlsReportConfiguration.setWhitePageBackground(false);
                xlsExporter.setConfiguration(xlsReportConfiguration);
                xlsExporter.exportReport();
		        byte[] xlsReport = outputByteArray.toByteArray();       
		        
		        return xlsReport;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeInputStreamSafely(stream);
		}
      return null;  

    }
	
	public byte[] generatePdf(String report, List<?> datas, Map<String, Object> parameters) throws JRException {

		InputStream stream = null ;
		JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(datas);
		JasperPrint jasperPrint = null;
		
		try{
			stream = new ClassPathResource(report).getInputStream();
			if(stream != null){
				jasperPrint = JasperFillManager.fillReport(stream, parameters, jrBeanCollectionDataSource);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeInputStreamSafely(stream);
		}
				
		byte[] pdfReport = JasperExportManager.exportReportToPdf(jasperPrint);
		return pdfReport;
	}
	
	public static void closeInputStreamSafely(InputStream stream){
		if(stream != null){
			try {
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}

}
