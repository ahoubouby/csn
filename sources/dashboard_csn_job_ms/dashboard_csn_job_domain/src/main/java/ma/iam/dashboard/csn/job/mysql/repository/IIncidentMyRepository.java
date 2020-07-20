package ma.iam.dashboard.csn.job.mysql.repository;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
public interface IIncidentMyRepository {
	
	void incidentsCiEtatSemaineParJour(List<Object[]> dataPg);
	
	void incidentsOuvertFermeEnNombre(List<Object[]> dataPg);
	
	void incidentsCiOuvertDivisionSemaine(List<Object[]> dataPg);
	
	void incidentsCiFermeDivisionSemaine(List<Object[]> dataPg);
	
	void incidentsCiOuvertActiviteSemaine(List<Object[]> dataPg);
	
	void incidentsCiFermeActiviteSemaine(List<Object[]> dataPg);
	
	void equipementsHS(List<Object[]> dataPg);
	
	void equipements2gHS(List<Object[]> dataPg);
	
	void equipements3gHS(List<Object[]> dataPg);
	
	void equipements4gHS(List<Object[]> dataPg);
	
	void msan(List<Object[]> dataPg);
	
	void dr(List<Object[]> dataPg);
	
	void dc(List<Object[]> dataPg);
	
	void fournisseur(List<Object[]> dataPg);
	
	void statMBTS(List<Object[]> dataPg);
	
	void statMSAN(List<Object[]> dataPg);

	Integer frequenceRequete(String tableName);
	
	Date nextExecutionRequete(String tableName) throws ParseException;
	
	Integer getDiffLastDay(String tableName) throws NumberFormatException;
}
