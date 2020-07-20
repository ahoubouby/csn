package ma.iam.dashboard.csn.services.implementations;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.iam.dashboard.csn.dtos.EquipementDto;
import ma.iam.dashboard.csn.dtos.SyntheseDto;
import ma.iam.dashboard.csn.mapper.EquipementMapper;
import ma.iam.dashboard.csn.repository.IIncidentRepository;
import ma.iam.dashboard.csn.services.IEquipementService;
import ma.iam.dashboard.csn.utils.Utils;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
@Service
@Transactional
public class EquipementServiceImpl implements IEquipementService {

	private final Logger logger = LoggerFactory.getLogger(EquipementServiceImpl.class);

	@Autowired
	private IIncidentRepository incidentRepository;		

	@Autowired
	private EquipementMapper equipementMapper;	
	
	public List<EquipementDto> getListEquipementsByParams(String dr, String dc, String fournisseur, String typeEquipement, String technologie) {
		List<Object[]> domains = new ArrayList<Object[]>();
		List<EquipementDto> dtos = new ArrayList<EquipementDto>();						
		domains = incidentRepository.equipementsHS(dr, dc, fournisseur, typeEquipement, technologie);
		if (domains != null && domains.size() > 0)
			try {
				dtos = equipementMapper.toDtos(domains);
				if (dtos != null && dtos.size() > 0) {
					logger.info(Utils.getLogParam() + " Recuperer Equipements Hors Service avec parametres => Total : " + dtos.size() +
						" DR : " + dr.toString() +
						" DC : " + dc.toString() +
						" Fournisseur : " + fournisseur.toString() +
						" Type Equipement: " + typeEquipement.toString() +
						" Technologie : " + technologie.toString()
						);
					return dtos;
				}
			} catch (ParseException e) {
				logger.error(Utils.getLogParam() + " Erreur  :" + e.getMessage() 
						+ " dans la recuparation des equipements hors service");
			}

		return dtos;
	}

	public List<SyntheseDto> getTabSyntheseEquipement(String typeEquipement){
		List<SyntheseDto> dtos = new ArrayList<SyntheseDto>();	
		List<Object[]> domains = incidentRepository.tab_equip(typeEquipement);

		if (domains != null && domains.size() > 0) 
		{
			dtos = equipementMapper.toSyntheseDtos(domains);
			if (dtos != null && dtos.size() > 0) {
				logger.info(Utils.getLogParam() + " Recuperer Equipements Hors Service avec parametres => Total : " + dtos.size() +
					" Type Equipement: " + typeEquipement.toString()
					);
				return dtos;
			}
		}
		return dtos;
	}
}