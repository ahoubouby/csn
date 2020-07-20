package ma.iam.dashboard.csn.job.postgres.repository;

import java.util.List;
/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
public interface IIncidentPgRepository {
	
	List<Object[]>  incidentsOuvertFermeEnNombre();
	
	List<Object[]>  incidentsCiEtatSemaineParJour(Integer diffDays);
	
	List<Object[]>  incidentsCiOuvertDivisionSemaine(Integer diffDays);
	
	List<Object[]>  incidentsCiFermeDivisionSemaine(Integer diffDays);
	
	List<Object[]>  incidentsCiOuvertActiviteSemaine(Integer diffDays);
	
	List<Object[]>  incidentsCiFermeActiviteSemaine(Integer diffDays);
	
	List<Object[]> equipementsHS();
	
	List<Object[]> equipements2gHS();
	
	List<Object[]> equipements3gHS();
	
	List<Object[]> equipements4gHS();
	
	List<Object[]> msan();
	
	List<Object[]> dr();
	
	List<Object[]> dc();
	
	List<Object[]> fournisseur();
	
	List<Object[]> statMbts();
	
	List<Object[]> statMsan();
	
}
