package ma.iam.dashboard.csn.services.implementations;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import ma.iam.dashboard.csn.dtos.CumulDetailDto;
import ma.iam.dashboard.csn.dtos.DashIncidentActiviteParentDto;
import ma.iam.dashboard.csn.dtos.DashIncidentCiEtatSemaineParJourParentDto;
import ma.iam.dashboard.csn.dtos.DashIncidentDateParentDto;
import ma.iam.dashboard.csn.dtos.DashIncidentNameParentDto;
import ma.iam.dashboard.csn.dtos.DashbIncidentOuvertFermeDto;
import ma.iam.dashboard.csn.mapper.DashboardIncidentMapper;
import ma.iam.dashboard.csn.repository.IDashboardRepository;
import ma.iam.dashboard.csn.services.IDashboardIncidentService;
import ma.iam.dashboard.csn.utils.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */

@Service
public class DashboardIncidentServiceImpl implements IDashboardIncidentService{

	private final Logger logger = LoggerFactory.getLogger(DashboardIncidentServiceImpl.class);

	@Autowired
	private IDashboardRepository dashboardRepository;		

	@Autowired
	private DashboardIncidentMapper dashboardChartMapper;	

//	@Override
//	public List<DashboardIncidentTraiteDto> incidentsTraitesParSemaine() {
//		List<Object[]> domains = new ArrayList<Object[]>();
//		List<DashboardIncidentTraiteDto> dtos = new ArrayList<DashboardIncidentTraiteDto>();						
//		domains = dashboardRepository.incidentsTraitesParSemaine();
//		if (domains != null && domains.size() > 0)
//			try {
//				dtos = dashboardChartMapper.toIncidentTraiteDtos(domains);
//			} catch (ParseException e) {
//				logger.error(Utils.getLogParam() + " Recuperer Incidents : Erreur de conversion de date !");
//				return dtos;
//			}
//		if (dtos != null && dtos.size() > 0) {
//			logger.info(Utils.getLogParam() + " Recuperer La liste des Incidents Traites Par Semaine");
//			return dtos;
//		}
//		return null;
//	}

//	@Override
//	public List<DashboardIncidentEnCoursDto> ciDerangementParActivite() {
//		List<Object[]> domains = new ArrayList<Object[]>();
//		List<DashboardIncidentEnCoursDto> dtos = new ArrayList<DashboardIncidentEnCoursDto>();							
//		domains = dashboardRepository.ciDerangementParActivite();
//		if (domains != null && domains.size() > 0)
//			dtos = dashboardChartMapper.toCiDerangementDtos(domains);
//		if (dtos != null && dtos.size() > 0) {
//			logger.info(Utils.getLogParam() + " Recuperer La liste des Incidents CI Derangement Par Activite");
//			return dtos;
//		}
//		return null;
//	}
//
//	@Override
//	public List<DashboardIncidentEnCoursDto> ciDerangementParRegion() {
//		List<Object[]> domains = new ArrayList<Object[]>();
//		List<DashboardIncidentEnCoursDto> dtos = new ArrayList<DashboardIncidentEnCoursDto>();							
//		domains = dashboardRepository.ciDerangementParRegion();
//		if (domains != null && domains.size() > 0)
//			dtos = dashboardChartMapper.toCiDerangementDtos(domains);
//		if (dtos != null && dtos.size() > 0) {
//			logger.info(Utils.getLogParam() + " Recuperer La liste des Incidents CI Derangement Par Region");
//			return dtos;
//		}
//		return null;
//	}
//
//
//	@Override
//	public List<DashboardIncidentDateDto> incidentsFermesParDivisionEnSemaine() {
//		List<Object[]> domains = new ArrayList<Object[]>();
//		List<DashboardIncidentDateDto> dtos = new ArrayList<DashboardIncidentDateDto>();							
//		domains = dashboardRepository.incidentsFermesParDivisionEnSemaine();
//		try {
//			if (domains != null && domains.size() > 0)
//				dtos = dashboardChartMapper.toIncidentsFermesDtos(domains);
//		} catch (ParseException e) {
//			logger.error(Utils.getLogParam()
//					+ " Erreur de conversion de date lors de la récupération des Incidents Fermes Par Division En Semaine =>"
//					+ e.getMessage());
//			return null;
//		}
//		if (dtos != null && dtos.size() > 0) {
//			logger.info(Utils.getLogParam() + " Recuperer  La liste des Incidents Fermes Par Division En Semaine");
//			return dtos;
//		}
//		return null;
//	}
//
//	@Override
//	public List<DashboardIncidentDateDto> incidentsFermesParActiviteEnSemaine() {
//		List<Object[]> domains = new ArrayList<Object[]>();
//		List<DashboardIncidentDateDto> dtos = new ArrayList<DashboardIncidentDateDto>();							
//		domains = dashboardRepository.incidentsFermesParActiviteEnSemaine();
//		try {
//			if (domains != null && domains.size() > 0)
//				dtos = dashboardChartMapper.toIncidentsFermesDtos(domains);
//		} catch (ParseException e) {
//			logger.error(Utils.getLogParam()
//					+ " Erreur de conversion de date lors de la récupération des Incidents Fermes Par Activité En Semaine =>"
//					+ e.getMessage());
//			return null;
//		}
//		if (dtos != null && dtos.size() > 0) {
//			logger.info(Utils.getLogParam() + " Recuperer La liste des Incidents  Fermes Par Activité En Semaine");
//			return dtos;
//		}
//		return null;
//	}

	@Override
	public List<DashIncidentCiEtatSemaineParJourParentDto> incidentsCiEtatSemaineParJour() {
		List<Object[]> domains = new ArrayList<Object[]>();
		List<DashIncidentCiEtatSemaineParJourParentDto> dtos = new ArrayList<DashIncidentCiEtatSemaineParJourParentDto>();							
		domains = dashboardRepository.incidentsCiEtatSemaineParJour();
		try {
			if (domains != null && domains.size() > 0)
				dtos = dashboardChartMapper.toIncidentsCiEtatSemaineParJourDtos(domains);
		} catch (ParseException e) {
			logger.error(Utils.getLogParam()
					+ " Erreur de conversion de date lors de la récupération des Incidents Traites durant une semaine Par Jour =>"
					+ e.getMessage());
			return null;
		}
		if (dtos != null && dtos.size() > 0) {
			logger.info(Utils.getLogParam() + " Recuperer La liste des Incidents Traites durant une semaine Par Jour");
			return dtos;
		}
		return null;
	}

//	@Override
//	public List<DashIncidentCiEtatJourParHeureParentDto> incidentsCiEtatJourParHeure() {
//		List<Object[]> domains = new ArrayList<Object[]>();
//		List<DashIncidentCiEtatJourParHeureParentDto> dtos = new ArrayList<DashIncidentCiEtatJourParHeureParentDto>();							
//		domains = dashboardRepository.incidentsCiEtatJourParHeure();
//		try {
//			if (domains != null && domains.size() > 0)
//				dtos = dashboardChartMapper.incidentsCiEtatJourParHeure(domains);
//		} catch (ParseException e) {
//			logger.error(Utils.getLogParam()
//					+ " Erreur de conversion de date lors de la récupération des Incidents Traites de la journée en cours par heure =>"
//					+ e.getMessage());
//			return null;
//		}
//		if (dtos != null && dtos.size() > 0) {
//			logger.info(Utils.getLogParam() + " Recuperer Total La liste des Incidents Traites de la journée en cours par heure");
//			return dtos;
//		}
//		return null;
//	}

	@Override
	public List<DashIncidentDateParentDto> incidentsCiOuvertDivisionSemaine() {
		List<Object[]> domains = new ArrayList<Object[]>();
		List<DashIncidentDateParentDto> dtos = new ArrayList<DashIncidentDateParentDto>();							
		domains = dashboardRepository.incidentsCiOuvertDivisionSemaine();
		try {
			if (domains != null && domains.size() > 0)
				dtos = dashboardChartMapper.toIncidentsDateDtos(domains);
		} catch (ParseException e) {
			logger.error(Utils.getLogParam()
					+ " Erreur de conversion de date lors de la récupération des Incidents CI Ouverts Par Division En Semaine =>"
					+ e.getMessage());
			return null;
		}
		if (dtos != null && dtos.size() > 0) {
			logger.info(Utils.getLogParam() + " Recuperer La liste des Incidents CI Ouverts Par Division  En Semaine");
			return dtos;
		}
		return null;
	}

	@Override
	public List<DashIncidentDateParentDto> incidentsCiFermeDivisionSemaine() {
		List<Object[]> domains = new ArrayList<Object[]>();
		List<DashIncidentDateParentDto> dtos = new ArrayList<DashIncidentDateParentDto>();							
		domains = dashboardRepository.incidentsCiFermeDivisionSemaine();
		try {
			if (domains != null && domains.size() > 0)
				dtos = dashboardChartMapper.toIncidentsDateDtos(domains);
		} catch (ParseException e) {
			logger.error(Utils.getLogParam()
					+ " Erreur de conversion de date lors de la récupération des Incidents CI Fermes Par Division En Semaine =>"
					+ e.getMessage());
			return null;
		}
		if (dtos != null && dtos.size() > 0) {
			logger.info(Utils.getLogParam() + " Recuperer La liste des Incidents CI Fermes Par Division En Semaine");
			return dtos;
		}
		return null;
	}

	@Override
	public List<DashIncidentNameParentDto>  incidentsCiOuvertParDirection(){
		List<Object[]> domains = new ArrayList<Object[]>();
		List<DashIncidentNameParentDto> dtos = new ArrayList<DashIncidentNameParentDto>();							
		domains = dashboardRepository.incidentsCiOuvertDivisionSemaine();
		try {
			if (domains != null && domains.size() > 0)
				dtos = dashboardChartMapper.toIncidentsNameDtos(domains);
		} catch (ParseException e) {
			logger.error(Utils.getLogParam()
					+ " Erreur de conversion de date lors de la récupération des Incidents CI Ouverts Par Division En Semaine =>"
					+ e.getMessage());
			return null;
		}
		if (dtos != null && dtos.size() > 0) {
			logger.info(Utils.getLogParam() + " Recuperer La liste des Incidents CI Ouverts Par Division  En Semaine");
			return dtos;
		}
		return null;

	}

	@Override
	public List<DashIncidentNameParentDto>  incidentsCiFermeParDirection(){
		List<Object[]> domains = new ArrayList<Object[]>();
		List<DashIncidentNameParentDto> dtos = new ArrayList<DashIncidentNameParentDto>();							
		domains = dashboardRepository.incidentsCiFermeDivisionSemaine();
		try {
			if (domains != null && domains.size() > 0)
				dtos = dashboardChartMapper.toIncidentsNameDtos(domains);
		} catch (ParseException e) {
			logger.error(Utils.getLogParam()
					+ " Erreur de conversion de date lors de la récupération des Incidents CI Fermes Par Division En Semaine =>"
					+ e.getMessage());
			return null;
		}
		if (dtos != null && dtos.size() > 0) {
			logger.info(Utils.getLogParam() + " Recuperer La liste des Incidents CI Fermes Par Division En Semaine");
			return dtos;
		}
		return null;
	}

	@Override
	public List<DashIncidentActiviteParentDto> incidentsCiOuvertActiviteSemaine() {
		List<Object[]> domains = new ArrayList<Object[]>();
		List<DashIncidentActiviteParentDto> dtos = new ArrayList<DashIncidentActiviteParentDto>();							
		domains = dashboardRepository.incidentsCiOuvertActiviteSemaine();
		try {
			if (domains != null && domains.size() > 0)
				dtos = dashboardChartMapper.toIncidentsActiviteDtos(domains);
		} catch (ParseException e) {
			logger.error(Utils.getLogParam()
					+ " Erreur de conversion de date lors de la récupération des Incidents CI Ouverts Par Activité En Semaine =>"
					+ e.getMessage());
			return null;
		}
		if (dtos != null && dtos.size() > 0) {
			logger.info(Utils.getLogParam() + " Recuperer La liste des Incidents CI Ouverts Par Activité En Semaine");
			return dtos;
		}
		return null;
	}

	@Override
	public List<DashIncidentDateParentDto> incidentsCiFermeActiviteSemaine() {
		List<Object[]> domains = new ArrayList<Object[]>();
		List<DashIncidentDateParentDto> dtos = new ArrayList<DashIncidentDateParentDto>();							
		domains = dashboardRepository.incidentsCiFermeActiviteSemaine();
		try {
			if (domains != null && domains.size() > 0)
				dtos = dashboardChartMapper.toIncidentsDateDtos(domains);
		} catch (ParseException e) {
			logger.error(Utils.getLogParam()
					+ " Erreur de conversion de date lors de la récupération des Incidents CI Fermes Par Activité En Semaine =>"
					+ e.getMessage());
			return null;
		}
		if (dtos != null && dtos.size() > 0) {
			logger.info(Utils.getLogParam() + " Recuperer La liste des Incidents CI Fermes Par Activité En Semaine");
			return dtos;
		}
		return null;
	}

	@Override
	public List<DashbIncidentOuvertFermeDto> incidentsOuvertFermeEnNombre() {
		List<Object[]> domains = new ArrayList<Object[]>();
		List<DashbIncidentOuvertFermeDto> dtos = new ArrayList<DashbIncidentOuvertFermeDto>();							
		domains = dashboardRepository.incidentsOuvertFermeEnNombre();
		if (domains != null && domains.size() > 0)
			dtos = dashboardChartMapper.toIncidentsOuvertFermeEnNombreDtos(domains);
		if (dtos != null && dtos.size() > 0) {
			logger.info(Utils.getLogParam() + " Recuperer La liste des Incidents Ouvert Ferme En Nombre");
			return dtos;
		}
		return null;
	}

	@Override
	public CumulDetailDto cumulDetails() {
		CumulDetailDto dto = new CumulDetailDto();
		Object domain = dashboardRepository.cumulDetails();
		if (domain == null){
			return null;
		}
		try {
			dto = dashboardChartMapper.toCumulDetailsDto(domain);
			logger.info(Utils.getLogParam() + " Recuperer Details Cumul des incidents");
		} catch (ParseException e) {
			logger.error(Utils.getLogParam()
					+ " Erreur de conversion de date lors de la récupération du Details Cumul des incidents =>"
					+ e.getMessage());
			return null;
		}
		return dto;
	}

}
