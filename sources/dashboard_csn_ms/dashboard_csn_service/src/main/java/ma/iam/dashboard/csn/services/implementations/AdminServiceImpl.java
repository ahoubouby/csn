package ma.iam.dashboard.csn.services.implementations;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ma.iam.dashboard.csn.dtos.IncidentActiviteAdminDto;
import ma.iam.dashboard.csn.mapper.IncidentActiviteAdminMapper;
import ma.iam.dashboard.csn.repository.IAdminRepository;
import ma.iam.dashboard.csn.services.IAdminService;
import ma.iam.dashboard.csn.utils.DateUtils;
import ma.iam.dashboard.csn.utils.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	private final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Autowired
	private IAdminRepository adminRepository;

	@Autowired
	private IncidentActiviteAdminMapper incidentActiviteAdminMapper;

	@Override
	public List<IncidentActiviteAdminDto> incidentsActiviteOuvert() {
		List<Object[]> domains = new ArrayList<Object[]>();
		List<IncidentActiviteAdminDto> dtos = new ArrayList<IncidentActiviteAdminDto>();						
		domains = adminRepository.incidentsActiviteOuvert();
		if (domains != null && domains.size() > 0)
			try {
				dtos = incidentActiviteAdminMapper.toDtos(domains);
			} catch (ParseException e) {
				logger.error(Utils.getLogParam() + " Erreur : " + e.getMessage() + " Dans La liste des Incidents Ouverts par Activite pour Admin");
				return dtos;
			}
		if (dtos != null && dtos.size() > 0) {
			logger.info(Utils.getLogParam() + " Recuper La liste des Incidents Ouverts par Activite pour Admin");
			return dtos;
		}
		return null;
	}

	@Override
	public IncidentActiviteAdminDto incidentActiviteOuvert(IncidentActiviteAdminDto dto) {
		Object[] domain ;
		if (dto != null){
			Date date;
			try {
				date = DateUtils.stringToDate(dto.getJour(), "dd/MM/yyyy");
				String jour = DateUtils.dateToString(date, "yyyy-MM-dd");
				domain = adminRepository.incidentActiviteOuvert(dto.getCommentaire(), jour, dto.getActivite());
				if(domain != null){
					logger.info(Utils.getLogParam() + " Ajouter Commentaire pour Incident Ouvert par Activite");
					return incidentActiviteAdminMapper.toDto(domain);
				}
			} catch (ParseException e) {
				logger.error(Utils.getLogParam() + " Erreur : " + e.getMessage()+ " dans Ajouter Commentaire pour Incident Ouvert par Activite");
				return null;
			}

		}
		return null;
	}

}