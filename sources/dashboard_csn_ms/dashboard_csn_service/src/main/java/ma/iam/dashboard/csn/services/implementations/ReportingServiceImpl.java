package ma.iam.dashboard.csn.services.implementations;

import java.util.ArrayList;
import java.util.List;

import ma.iam.dashboard.csn.dtos.ReportingDto;
import ma.iam.dashboard.csn.services.IReportingService;
import ma.iam.dashboard.csn.utils.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
@Service
public class ReportingServiceImpl implements IReportingService {
	
	private final Logger logger = LoggerFactory.getLogger(ReportingServiceImpl.class);
	
	public List<ReportingDto> getListEquipementReportingByCriteres(String dr, String dc, String technologie, String infrastructure) {
		List<ReportingDto> dtos = new ArrayList<ReportingDto>();
		logger.info(Utils.getLogParam() + "Export Total : " + dtos.size() + " equipements avec parametres");
		return dtos;
	}
	
}
