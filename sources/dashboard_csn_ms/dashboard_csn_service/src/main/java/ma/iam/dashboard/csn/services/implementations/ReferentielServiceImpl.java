package ma.iam.dashboard.csn.services.implementations;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.iam.dashboard.csn.dtos.DcDto;
import ma.iam.dashboard.csn.dtos.DrDto;
import ma.iam.dashboard.csn.dtos.FournisseurDto;
import ma.iam.dashboard.csn.mapper.DcMapper;
import ma.iam.dashboard.csn.mapper.DrMapper;
import ma.iam.dashboard.csn.mapper.FournisseurMapper;
import ma.iam.dashboard.csn.repository.IReferentielRepository;
import ma.iam.dashboard.csn.services.IReferentielService;
import ma.iam.dashboard.csn.utils.Utils;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
@Service
public class ReferentielServiceImpl implements IReferentielService {

	private final Logger logger = LoggerFactory.getLogger(ReferentielServiceImpl.class);

	@Autowired
	private IReferentielRepository referentielRepository;		

	@Autowired
	private DrMapper drMapper;
	@Autowired
	private DcMapper dcMapper;
	@Autowired
	private FournisseurMapper fournisseurMapper;	
	
	public List<DrDto> getAllDr(){
		try {
			List<Object[]> domains = referentielRepository.getDrList();
			logger.info(Utils.getLogParam() + " Recuperer la liste des DR ");
			if(domains != null) {
					return drMapper.toDtos(domains);
				
			}
		} catch (ParseException e) {
			logger.info(Utils.getLogParam() + " Erreur de conversion !");
		}
		return null;
	}

	public List<DcDto> getAllDcByDr(Long idDr){
		try {
			List<Object[]> domains = referentielRepository.getDcByDr(idDr);
			logger.info(Utils.getLogParam() + " Recuperer la liste des DR ");
			if(domains != null) {
					return dcMapper.toDtos(domains);
				
			}
		} catch (ParseException e) {
			logger.info(Utils.getLogParam() + " Erreur de conversion !");
		}
		return null;
	}

	@Override
	public List<FournisseurDto> getFournisseurs(String typeEquipement) {
		try {
			List<Object[]> domains = referentielRepository.getFournisseurList(typeEquipement);
			logger.info(Utils.getLogParam() + " Recuperer la liste des Fournisseurs ");
			if(domains != null) {
					return fournisseurMapper.toDtos(domains);
				
			}
		} catch (ParseException e) {
			logger.info(Utils.getLogParam() + " Erreur de conversion !");
		}
		return null;
	}
}
