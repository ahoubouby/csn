package ma.iam.dashboard.csn.services;

import java.util.List;

import ma.iam.dashboard.csn.dtos.CumulDetailDto;
import ma.iam.dashboard.csn.dtos.DashIncidentActiviteParentDto;
import ma.iam.dashboard.csn.dtos.DashIncidentCiEtatSemaineParJourParentDto;
import ma.iam.dashboard.csn.dtos.DashIncidentDateParentDto;
import ma.iam.dashboard.csn.dtos.DashIncidentNameParentDto;
import ma.iam.dashboard.csn.dtos.DashbIncidentOuvertFermeDto;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
public interface IDashboardIncidentService {

//	List<DashboardIncidentTraiteDto> incidentsTraitesParSemaine();
//	List<DashboardIncidentDateDto> incidentsFermesParDivisionEnSemaine();
//	List<DashboardIncidentDateDto> incidentsFermesParActiviteEnSemaine();
//	List<DashboardIncidentEnCoursDto> ciDerangementParActivite();
//	List<DashboardIncidentEnCoursDto> ciDerangementParRegion();
	List<DashIncidentCiEtatSemaineParJourParentDto> incidentsCiEtatSemaineParJour();
//	List<DashIncidentCiEtatJourParHeureParentDto> incidentsCiEtatJourParHeure();
	List<DashIncidentDateParentDto>  incidentsCiOuvertDivisionSemaine();	
	List<DashIncidentDateParentDto>  incidentsCiFermeDivisionSemaine();	
	List<DashIncidentNameParentDto>  incidentsCiOuvertParDirection();	
	List<DashIncidentNameParentDto>  incidentsCiFermeParDirection();	
	List<DashIncidentActiviteParentDto>  incidentsCiOuvertActiviteSemaine();	
	List<DashIncidentDateParentDto>  incidentsCiFermeActiviteSemaine();
	List<DashbIncidentOuvertFermeDto>  incidentsOuvertFermeEnNombre();
	CumulDetailDto cumulDetails();
}
