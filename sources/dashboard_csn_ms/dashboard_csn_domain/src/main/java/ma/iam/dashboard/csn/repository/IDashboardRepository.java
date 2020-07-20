package ma.iam.dashboard.csn.repository;

import java.util.List;

public interface IDashboardRepository {
//List<Object[]>  incidentsTraitesParSemaine();

//	List<Object[]> ciDerangementParActivite();
//	
//	List<Object[]> ciDerangementParRegion();
//	
//	List<Object[]> incidentsFermesParDivisionEnSemaine();
//
//	List<Object[]> incidentsFermesParActiviteEnSemaine();

	List<Object[]>  incidentsCiEtatSemaineParJour();
	
//	List<Object[]>  incidentsCiEtatJourParHeure();
	
	List<Object[]>  incidentsCiOuvertDivisionSemaine();
	
	List<Object[]>  incidentsCiFermeDivisionSemaine();
	
	List<Object[]>  incidentsCiOuvertActiviteSemaine();
	
	List<Object[]>  incidentsCiFermeActiviteSemaine();
	
	List<Object[]>  incidentsOuvertFermeEnNombre();
	
	Object cumulDetails();
}
