package ma.iam.dashboard.csn.job.services.implementations;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.iam.dashboard.csn.job.constants.Constants;
import ma.iam.dashboard.csn.job.job.services.interfaces.IDashboardCsnLoadDataService;
import ma.iam.dashboard.csn.job.mysql.repository.IIncidentMyRepository;
import ma.iam.dashboard.csn.job.postgres.repository.IIncidentPgRepository;
/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
@Service
public class DashboardCsnLoadDataServiceImpl implements IDashboardCsnLoadDataService{

	private final Logger logger = LoggerFactory.getLogger(DashboardCsnLoadDataServiceImpl.class);

	@Autowired
	private IIncidentPgRepository incidentPgRepository;

	@Autowired
	private IIncidentMyRepository incidentMyRepository;

	@Override
	public void loadReq1() {
		// Req1
				String tableName = "req1";
				if(isTimeToExecute(tableName)){
					try{
						List<Object[]> data = new ArrayList<Object[]>();
						try{
							data = incidentPgRepository.incidentsOuvertFermeEnNombre();
							logger.info(" Recuperer le cumul des incidents du jour depuis la bdd distante");
						}catch(Exception e){
							logger.error("Erreur : " + e.getMessage() + " dans la requete de recuperation du cumul des incidents du jour depuis la bdd distante");
						}

						if(data != null && data.size() >0) {
							try{
								incidentMyRepository.incidentsOuvertFermeEnNombre(data);
								logger.info("vider la table req1 : ");
								logger.info("Inserer le cumul des incidents du jour dans la bdd local");
							}catch(Exception e){
								logger.error("Erreur : " + e.getMessage() + " dans la requete d\'insertion du cumul des incidents du jour dans la bdd local");
							}
						}
					}catch(Exception e){
						logger.error("Erreur : " + e.getMessage() + " dans la requete du cumul des incidents du jour");
					}
				}
	}

	@Override
	public void loadReq2() {
		// Req2
		String tableName = "req2";
		if(isTimeToExecute(tableName)){
			try{
				List<Object[]> data = new ArrayList<Object[]>();
				Integer diff = getDiffLastDay(tableName);
				if(diff == null) {
					diff = 1;
				}
				try{
					data = incidentPgRepository.incidentsCiEtatSemaineParJour(diff);
					logger.info(" Recuperer La liste des Incidents Ci Ouverts/Fermes par Semaine depuis la bdd distante : " + data.size());
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete de recuperation des Incidents Ci Ouverts/Fermes par Semaine depuis la bdd distante");
				}

				if(data != null && data.size() >0) {
					try{
						incidentMyRepository.incidentsCiEtatSemaineParJour(data);
						logger.info("vider la table req2 : ");
						logger.info("Inserer La liste des Incidents Ci Ouverts/Fermes par Semaine dans la bdd local");
					}catch(Exception e){
						logger.error("Erreur : " + e.getMessage() + " dans la requete d\'insertion des Incidents Ci Ouverts/Fermes par Semaine dans la bdd local");
					}
				}
			}catch(Exception e){
				logger.error("Erreur : " + e.getMessage() + " dans la requete des Incidents Ci Ouverts/Fermes par Semaine");
			}
		}
	}

	@Override
	public void loadReq3() {
		// Req3
		String tableName = "req3";
		if(isTimeToExecute(tableName)){
			try{
				List<Object[]> data = new ArrayList<Object[]>();
				Integer diff = getDiffLastDay(tableName);
				if(diff == null) {
					diff = 1;
				}
				try{
					data = incidentPgRepository.incidentsCiOuvertDivisionSemaine(diff);
					logger.info(" Recuperer La liste des Incidents Ouverts par Division depuis la bdd distante : " + data.size());
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete de recuperation des Incidents Fermes par Division depuis la bdd distante");
				}
				if(data != null && data.size() >0) {
					try{
						incidentMyRepository.incidentsCiOuvertDivisionSemaine(data);
						logger.info("vider la table req3 : ");
						logger.info("Inserer La liste des Incidents Ouverts par Division dans la bdd local");	
					}catch(Exception e){
						logger.error("Erreur : " + e.getMessage() + " dans la requete d\'insertion des Incidents Fermes par Division dans la bdd local");
					}
				}
			}catch(Exception e){
				logger.error("Erreur : " + e.getMessage() + " dans la requete des Incidents Ouverts par Division");
			}
		}
	}
	
	@Override
	public void loadReq4() {
		// Req4
		String tableName = "req4";
		if(isTimeToExecute(tableName)){
			try{
				List<Object[]> data = new ArrayList<Object[]>();
				Integer diff = getDiffLastDay(tableName);
				if(diff == null) {
					diff = 1;
				}
				try{
					data = incidentPgRepository.incidentsCiFermeDivisionSemaine(diff);
					logger.info(" Recuperer La liste des Incidents Fermes par Division depuis la bdd distante : " + data.size());
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete de recuperation des Incidents Fermes par Division depuis la bdd distante");
				}
				if(data != null && data.size() >0) {
					try{
						incidentMyRepository.incidentsCiFermeDivisionSemaine(data);
						logger.info("vider la table req4 : ");
						logger.info("Inserer La liste des Incidents Fermes par Division dans la bdd local");	
					}catch(Exception e){
						logger.error("Erreur : " + e.getMessage() + " dans la requete d\'insertion des IncidentsFermes par Division dans la bdd local");
					}
				}
			}catch(Exception e){
				logger.error("Erreur : " + e.getMessage() + " dans la requete des Incidents Fermes par Division");
			}
		}
	}

	@Override
	public void loadReq5() {
		// Req5
		String tableName = "req5";
		if(isTimeToExecute(tableName)){
			try{
				List<Object[]> data = new ArrayList<Object[]>();
				Integer diff = getDiffLastDay(tableName);
				if(diff == null) {
					diff = 1;
				}
				try{
					data = incidentPgRepository.incidentsCiOuvertActiviteSemaine(diff);
					logger.info(" Recuperer La liste des Incidents Ouverts par Activite depuis la bdd distante : " + data.size());
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete de recuperation des IncidentsOuverts par Activite depuis la bdd distante");
				}
				if(data != null && data.size() >0) {
					try{
						incidentMyRepository.incidentsCiOuvertActiviteSemaine(data);
						logger.info("vider la table req5 : ");
						logger.info("Inserer La liste des Incidents Ouverts par Activite dans la bdd local");
					}catch(Exception e){
						logger.error("Erreur : " + e.getMessage() + " dans la requete d\'insertion des Incidents Ouverts par Activite dans la bdd local");
					}
				}
			}catch(Exception e){
				logger.error("Erreur : " + e.getMessage() + " dans la requete des Incidents Ouverts par Activite");
			}
		}
	}

	@Override
	public void loadReq6() {
		// Req6
		String tableName = "req6";
		if(isTimeToExecute(tableName)){
			try{
				List<Object[]> data = new ArrayList<Object[]>();
				Integer diff = getDiffLastDay(tableName);
				if(diff == null) {
					diff = 1;
				}
				try{
					data = incidentPgRepository.incidentsCiFermeActiviteSemaine(diff);
					logger.info(" Recuperer La liste des Incidents Fermes par Activite depuis la bdd distante : " + data.size());
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete de recuperation des Incidents Fermes par Activite depuis la bdd distante");
				}
				if(data != null && data.size() >0) {
					try{
						incidentMyRepository.incidentsCiFermeActiviteSemaine(data);
						logger.info("vider la table req6 : ");
						logger.info("Inserer La liste des Incidents Fermes par Activite dans la bdd local");
					}catch(Exception e){
						logger.error("Erreur : " + e.getMessage() + " dans la requete d\'insertion des Incidents Incidents Fermes par Activite dans la bdd local");
					}
				}
			}catch(Exception e){
				logger.error("Erreur : " + e.getMessage() + " dans la requete des Incidents Fermes par Activite");
			}
		}
	}
	
	@Override
	public void loadData() {
		
		
		
		// reqEquip
		String tableEquip = "reqEquip";
		if(isTimeToExecute(tableEquip)){		
			try{
				List<Object[]> hs = new ArrayList<Object[]>();
				try{
					hs = incidentPgRepository.equipementsHS();
					logger.info(" Recuperer La liste des equipements HS Mobile depuis la bdd distante : " + hs.size());
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete de recuperation des equipements HS Mobile depuis la bdd distante");
				}
				try{
					incidentMyRepository.equipementsHS(hs);
					logger.info("vider la table reqEquip : ");
					logger.info("Inserer La liste des equipements HS Mobile dans la bdd local");
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete d\'insertion des equipements HS Mobile dans la bdd local");
				}


			}catch(Exception e){
				logger.error("Erreur : " + e.getMessage() + " dans la requete des des equipements HS Mobile");
			}
		}

		// reqEquip2g
		String tableEquip2g = "reqEquip2g";
		if(isTimeToExecute(tableEquip2g)){
			try{
				List<Object[]> hs2g = new ArrayList<Object[]>();
				try{
					hs2g = incidentPgRepository.equipements2gHS();
					logger.info(" Recuperer La liste des equipements HS Mobile 2g depuis la bdd distante : " + hs2g.size());
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete de recuperation des equipements HS Mobile 2g depuis la bdd distante");
				}
				try{
					incidentMyRepository.equipements2gHS(hs2g);
					logger.info("vider la table reqEquip2g : ");
					logger.info("Inserer La liste des equipements HS Mobile 2g dans la bdd local");
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete d\'insertion des equipements HS Mobile 2g dans la bdd local");
				}


			}catch(Exception e){
				logger.error("Erreur : " + e.getMessage() + " dans la requete des equipements HS Mobile 2g");
			}
		}

		// reqEquip3g
		String tableEquip3g = "reqEquip3g";
		if(isTimeToExecute(tableEquip3g)){
			try{
				List<Object[]> hs3g = new ArrayList<Object[]>();
				try{
					hs3g = incidentPgRepository.equipements3gHS();
					logger.info(" Recuperer La liste des equipements HS Mobile 3g depuis la bdd distante : " + hs3g.size());
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete de recuperation des equipements HS Mobile 3g depuis la bdd distante");
				}
				try{
					incidentMyRepository.equipements3gHS(hs3g);
					logger.info("vider la table reqEquip3g : ");
					logger.info("Inserer La liste des equipements HS Mobile 3g dans la bdd local");
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete d\'insertion des equipements HS Mobile 3g dans la bdd local");
				}


			}catch(Exception e){
				logger.error("Erreur : " + e.getMessage() + " dans la requete des equipements HS Mobile 3g");
			}
		}

		// reqEquip4g
		String tableEquip4g = "reqEquip4g";
		if(isTimeToExecute(tableEquip4g)){
			try{
				List<Object[]> hs4g = new ArrayList<Object[]>();
				try{
					hs4g = incidentPgRepository.equipements4gHS();
					logger.info(" Recuperer La liste des equipements HS Mobile 4g depuis la bdd distante : " + hs4g.size());
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete de recuperation des equipements HS Mobile 4g depuis la bdd distante");
				}
				try{
					incidentMyRepository.equipements4gHS(hs4g);
					logger.info("vider la table reqEquip4g : ");
					logger.info("Inserer La liste des equipements HS Mobile 4g dans la bdd local");
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete d\'insertion des equipements HS Mobile 4g dans la bdd local");
				}


			}catch(Exception e){
				logger.error("Erreur : " + e.getMessage() + " dans la requete des equipements HS Mobile 4g");
			}
		}

		// reqmsan
		String tableMSAN = "reqmsan";
		if(isTimeToExecute(tableMSAN)){
			try{
				List<Object[]> msan = new ArrayList<Object[]>();
				try{
					msan = incidentPgRepository.msan();
					logger.info(" Recuperer La liste des equipements HS MSAN depuis la bdd distante : " + msan.size());
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete de recuperation des equipements HS MSAN depuis la bdd distante");
				}
				try{
					incidentMyRepository.msan(msan);
					logger.info("vider la table reqmsan : ");
					logger.info("Inserer La liste des equipements HS MSAN dans la bdd local");
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete d\'insertion des equipements HS MSAN dans la bdd local");
				}


			}catch(Exception e){
				logger.error("Erreur : " + e.getMessage() + " dans la requete des equipements HS MSAN");
			}	
		}

		// dr
		String tableDr = "dr";
		if(isTimeToExecute(tableDr)){
			try{
				List<Object[]> drs = new ArrayList<Object[]>();
				try{
					drs = incidentPgRepository.dr();
					logger.info(" Recuperer La liste des drs depuis la bdd distante : " + drs.size());
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete de recuperation des DRs depuis la bdd distante");
				}
				try{
					incidentMyRepository.dr(drs);
					logger.info("vider la table dr : ");
					logger.info("Inserer La liste des drs dans la bdd local");
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete d\'insertion des DRs dans la bdd local");
				}


			}catch(Exception e){
				logger.error("Erreur : " + e.getMessage() + " dans la requete des DRs");
			}
		}

		// dc
		String tableDc = "dc";
		if(isTimeToExecute(tableDc)){
			try{
				List<Object[]> dcs = new ArrayList<Object[]>();
				try{
					dcs = incidentPgRepository.dc();
					logger.info(" Recuperer La liste des DCs depuis la bdd distante : " + dcs.size());
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete de recuperation des DCs depuis la bdd distante");
				}
				try{
					incidentMyRepository.dc(dcs);
					logger.info("vider la table dc : ");
					logger.info("Inserer La liste des dcs dans la bdd local");
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete d\'insertion des DCs dans la bdd local");
				}

			}catch(Exception e){
				logger.error("Erreur : " + e.getMessage() + " dans la requete des DCs");
			}
		}

		// fournisseur
		String tableFournisseur = "fournisseur";
		if(isTimeToExecute(tableFournisseur)){
			try{
				List<Object[]> fournisseurs = new ArrayList<Object[]>();
				try{
					fournisseurs = incidentPgRepository.fournisseur();
					logger.info(" Recuperer La liste des fournisseurs depuis la bdd distante : " + fournisseurs.size());
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete de recuperation des fournisseurs depuis la bdd distante");
				}
				try{
					incidentMyRepository.fournisseur(fournisseurs);
					logger.info("vider la table fournisseur : ");
					logger.info("Inserer La liste des fournisseurs dans la bdd local");
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete d\'insertion des fournisseurs dans la bdd local");
				}

			}catch(Exception e){
				logger.error("Erreur : " + e.getMessage() + " dans la requete des fournisseurs");
			}
		}

		// req_stat_mbts
		String tableReqTabMBTS = "req_stat_mbts";
		if(isTimeToExecute(tableReqTabMBTS)){
			try{
				List<Object[]> tabMBTS = new ArrayList<Object[]>();
				try{
					tabMBTS = incidentPgRepository.statMbts();
					logger.info(" Recuperer Les statistiques MBTS depuis la bdd distante : " + tabMBTS.size());
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete de recuperation des statistiques MBTS depuis la bdd distante");
				}
				try{
					incidentMyRepository.statMBTS(tabMBTS);
					logger.info("vider la table statistiques MBTS : ");
					logger.info("Inserer La liste des statistiques MBTS dans la bdd local");
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete d\'insertion des statistiques MBTS dans la bdd local");
				}

			}catch(Exception e){
				logger.error("Erreur : " + e.getMessage() + " dans la requete des statistiques MBTS");
			}
		}

		// req_stat_msan
		String tableReqTabMSAN = "req_stat_msan";
		if(isTimeToExecute(tableReqTabMSAN)){
			try{
				List<Object[]> tabMSAN = new ArrayList<Object[]>();
				try{
					tabMSAN = incidentPgRepository.statMsan();
					logger.info(" Recuperer Les statistiques MSAN depuis la bdd distante : " + tabMSAN.size());
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete de recuperation des statistiques MSAN depuis la bdd distante");
				}
				try{
					incidentMyRepository.statMSAN(tabMSAN);
					logger.info("vider la table statistiques MSAN : ");
					logger.info("Inserer La liste des statistiques MSAN dans la bdd local");
				}catch(Exception e){
					logger.error("Erreur : " + e.getMessage() + " dans la requete d\'insertion des statistiques MSAN dans la bdd local");
				}

			}catch(Exception e){
				logger.error("Erreur : " + e.getMessage() + " dans la requete des statistiques MSAN");
			}
		}
	}
	
	private boolean isTimeToExecute(String tableName){
		Integer frequence= incidentMyRepository.frequenceRequete(tableName);
		if(frequence != null && frequence > 0){
			if(frequence == 1)
				return true;
			Date execution;
			try {
				execution = incidentMyRepository.nextExecutionRequete(tableName);
				if(execution == null) {
					return true;
				}
				Calendar cal = Calendar.getInstance();
				cal.setTime(execution);
				Date dateNext = cal.getTime();
				Date dateNow = new Date();
				if(dateNext != null){
					return dateNow.compareTo(dateNext) >= 0;
				}

			} catch (ParseException e) {
				logger.error("Erreur : " + e.getMessage() 
						+ " de conversion de date dans la table parametrage qui verifie le temps d'execution de job pour la requete : " 
						+ tableName);
				return false;
			}
		}
		return false;
	}
	
	private Integer getDiffLastDay(String tableName) {
		try {
			Integer value = incidentMyRepository.getDiffLastDay(tableName);
			
			if(value == null) {
				return Constants.DIFF_LAST_DAY_MAX;
			}
			if(value < Constants.DIFF_LAST_DAY_MIN) {
				return Constants.DIFF_LAST_DAY_MIN;
			}
			if(value > Constants.DIFF_LAST_DAY_MAX) {
				return Constants.DIFF_LAST_DAY_MAX;
			}
			return value;
		} catch(NumberFormatException e){
			logger.error("Erreur : " + e.getMessage() 
			+ " de conversion d'entier lors de chargement de la nombre des jours manquants de la requete : " 
			+ tableName);
			return null;
		}
	}
}
