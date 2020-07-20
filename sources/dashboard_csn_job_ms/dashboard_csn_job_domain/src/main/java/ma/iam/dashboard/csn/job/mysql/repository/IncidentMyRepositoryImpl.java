package ma.iam.dashboard.csn.job.mysql.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ma.iam.dashboard.csn.job.mysql.constants.Constants;
import ma.iam.dashboard.csn.job.mysql.constants.QueryConstants;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
@Repository
public class IncidentMyRepositoryImpl implements IIncidentMyRepository {

	private final Logger logger = LoggerFactory.getLogger(IncidentMyRepositoryImpl.class);
	
	@Autowired
	@Qualifier("entityManagerFactory")
	private EntityManager entityManager;

	@Override
	@Transactional
	public void incidentsOuvertFermeEnNombre(List<Object[]> dataPg) {
		int cleaned =  entityManager.createNativeQuery(QueryConstants.CLEAN_REQ_1).executeUpdate();
		logger.info(Constants.CLEAN_MESSAGE_REQ_1, cleaned);
		insertQuery(QueryConstants.INSERT_REQ_1, dataPg, 2);
		updateParametrage(Constants.REQ_1);
	}

	@Override
	@Transactional
	public void incidentsCiEtatSemaineParJour(List<Object[]> dataPg) {
		String cleanSql = QueryConstants.CLEAN_REQ_2;
		int cleaned = entityManager.createNativeQuery(cleanSql).executeUpdate();
		logger.info(Constants.CLEAN_MESSAGE_REQ_2, cleaned);
		insertQuery(QueryConstants.INSERT_REQ_2, dataPg, 3);
		updateParametrage(Constants.REQ_2);
	}

	@Override
	@Transactional
	public void incidentsCiOuvertDivisionSemaine(List<Object[]> dataPg) {
		String cleanSql = QueryConstants.CLEAN_REQ_3;
		int cleaned = entityManager.createNativeQuery(cleanSql).executeUpdate();
		logger.info(Constants.CLEAN_MESSAGE_REQ_3, cleaned);
		insertQuery(QueryConstants.INSERT_REQ_3, dataPg, 3);
		updateParametrage(Constants.REQ_3);
	}

	@Override
	@Transactional
	public void incidentsCiFermeDivisionSemaine(List<Object[]> dataPg) {
		String cleanSql = QueryConstants.CLEAN_REQ_4;
		int cleaned = entityManager.createNativeQuery(cleanSql).executeUpdate();
		logger.info(Constants.CLEAN_MESSAGE_REQ_4, cleaned);
		insertQuery(QueryConstants.INSERT_REQ_4, dataPg, 3);
		
		updateParametrage(Constants.REQ_4);
	}

	@Override
	@Transactional
	public void incidentsCiOuvertActiviteSemaine(List<Object[]> dataPg) {
		String cleanSql = QueryConstants.CLEAN_REQ_5;
		int cleaned = entityManager.createNativeQuery(cleanSql).executeUpdate();
		logger.info(Constants.CLEAN_MESSAGE_REQ_5, cleaned);
		insertQuery(QueryConstants.INSERT_REQ_5, dataPg, 3);
		updateParametrage(Constants.REQ_5);
	}

	@Override
	@Transactional
	public void incidentsCiFermeActiviteSemaine(List<Object[]> dataPg) {
		String cleanSql = QueryConstants.CLEAN_REQ_6;
		int cleaned = entityManager.createNativeQuery(cleanSql).executeUpdate();
		logger.info(Constants.CLEAN_MESSAGE_REQ_6, cleaned);
		insertQuery(QueryConstants.INSERT_REQ_6, dataPg, 3);
		updateParametrage(Constants.REQ_6);
	}

	@Override
	@Transactional
	public void equipementsHS(List<Object[]> dataPg) {
		int cleaned = entityManager.createNativeQuery(QueryConstants.CLEAN_REQ_EQUIP).executeUpdate();
		logger.info(Constants.CLEAN_MESSAGE_REQ_EQUIP, cleaned);
		insertQuery(QueryConstants.INSERT_REQ_EQUIP, dataPg, 13);
		updateParametrage(Constants.REQ_EQUIP);
	}

	@Override
	@Transactional
	public void equipements2gHS(List<Object[]> dataPg) {
		int cleaned =  entityManager.createNativeQuery(QueryConstants.CLEAN_REQ_EQUIP2G).executeUpdate();
		logger.info(Constants.CLEAN_MESSAGE_REQ_EQUIP2G, cleaned);
		insertQuery(QueryConstants.INSERT_REQ_EQUIP2G, dataPg, 13);
		updateParametrage(Constants.REQ_EQUIP2G);
	}

	@Override
	@Transactional
	public void equipements3gHS(List<Object[]> dataPg) {
		int cleaned =  entityManager.createNativeQuery(QueryConstants.CLEAN_REQ_EQUIP3G).executeUpdate();
		logger.info(Constants.CLEAN_MESSAGE_REQ_EQUIP3G, cleaned);
		insertQuery(QueryConstants.INSERT_REQ_EQUIP3G, dataPg, 13);
		updateParametrage(Constants.REQ_EQUIP3G);
	}

	@Override
	@Transactional
	public void equipements4gHS(List<Object[]> dataPg) {
		int cleaned = entityManager.createNativeQuery(QueryConstants.CLEAN_REQ_EQUIP4G).executeUpdate();
		logger.info(Constants.CLEAN_MESSAGE_REQ_EQUIP4G, cleaned);
		insertQuery(QueryConstants.INSERT_REQ_EQUIP4G, dataPg, 13);
		updateParametrage(Constants.REQ_EQUIP4G);
	}

	@Override
	@Transactional
	public void msan(List<Object[]> dataPg) {
		int cleaned = entityManager.createNativeQuery(QueryConstants.CLEAN_REQ_MSAN).executeUpdate();
		logger.info(Constants.CLEAN_MESSAGE_REQ_MSAN, cleaned);
		insertQuery(QueryConstants.INSERT_REQ_MSAN, dataPg, 13);
		updateParametrage(Constants.REQ_MSAN);
	}

	@Override
	@Transactional
	public void dr(List<Object[]> dataPg) {
		int cleaned =  entityManager.createNativeQuery(QueryConstants.CLEAN_REQ_DR).executeUpdate();
		logger.info(Constants.CLEAN_MESSAGE_REQ_DR, cleaned);
		insertQuery(QueryConstants.INSERT_REQ_DR, dataPg, 2);
		updateParametrage(Constants.REQ_DR);
	}
	@Override
	@Transactional
	public void dc(List<Object[]> dataPg) {
		int cleaned =  entityManager.createNativeQuery(QueryConstants.CLEAN_REQ_DC).executeUpdate();
		logger.info(Constants.CLEAN_MESSAGE_REQ_DC, cleaned);
		insertQuery(QueryConstants.INSERT_REQ_DC, dataPg, 3);
		updateParametrage(Constants.REQ_DC);
	}
	
	@Override
	@Transactional
	public void fournisseur(List<Object[]> dataPg) {
		int cleaned =  entityManager.createNativeQuery(QueryConstants.CLEAN_REQ_FOURNISSEUR).executeUpdate();
		logger.info(Constants.CLEAN_MESSAGE_REQ_FOURNISSEUR, cleaned);
		insertQuery(QueryConstants.INSERT_REQ_FOURNISSEUR, dataPg, 3);
		updateParametrage(Constants.REQ_FOURNISSEUR);
	}
	
	@Override
	@Transactional
	public void statMBTS(List<Object[]> dataPg) {
		int cleaned =  entityManager.createNativeQuery(QueryConstants.CLEAN_REQ_STAT_MBTS).executeUpdate();
		logger.info(Constants.CLEAN_MESSAGE_REQ_STAT_MBTS, cleaned);
		insertQuery(QueryConstants.INSERT_REQ_STAT_MBTS, dataPg, 2);
		updateParametrage(Constants.REQ_STAT_MBTS);
	}
	
	@Override
	@Transactional
	public void statMSAN(List<Object[]> dataPg) {
		int cleaned =  entityManager.createNativeQuery(QueryConstants.CLEAN_REQ_STAT_MSAN).executeUpdate();
		logger.info(Constants.CLEAN_MESSAGE_REQ_STAT_MSAN, cleaned);
		insertQuery(QueryConstants.INSERT_REQ_STAT_MSAN, dataPg, 2);
		updateParametrage(Constants.REQ_STAT_MSAN);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Integer frequenceRequete(String tableName) throws NumberFormatException {
		List<Object> domains = entityManager
				.createNativeQuery(QueryConstants.SQL_GET_FREQUENCE)
				.setParameter(1, tableName)
				.getResultList();
		if(domains != null && domains.size() > 0 ){
			return Integer.valueOf(domains.get(0).toString());
		}
		return null;		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Date nextExecutionRequete(String tableName) throws ParseException {
		List<Object> domains = entityManager
				.createNativeQuery(QueryConstants.SQL_GET_NEXT_EXECUTION)
				.setParameter(1, tableName)
				.getResultList();
		Date execution = null;
		if(domains != null && domains.size() > 0 ){
			if(domains.get(0) == null) {
				return null;
			}
			SimpleDateFormat sdf=new SimpleDateFormat(Constants.PARAMETRAGE_DATE_FORMAT);
			execution =  sdf.parse(domains.get(0).toString());
		}
		return execution;
	}
	
	@Transactional
	private void insertQuery(String sql, List<Object[]> data, int numCols) {
		for(Object[] o : data){
			Query q = entityManager.createNativeQuery(sql);
			fillParams(q, o, numCols);
			q.executeUpdate();
		}
	}
	
	private void fillParams(Query q, Object[] o, int numParams) {
		for(int i=0; i<numParams; i++) {
			q = q.setParameter(i+1, o[i]);
		}
	}
	
	@Transactional
	private void updateParametrage(String tableName) {
		boolean withHour = false;
		Integer frequence  = frequenceRequete(tableName);
		if(frequence != null && frequence < 24){
				withHour = true;
		}
		String hour = "%Y-%m-%d" + (withHour ?  " %H:00" : "");
		int update = entityManager
				.createNativeQuery(QueryConstants.SQL_UPDATE_PARAMETRAGE)
				.setParameter(1, hour)
				.setParameter(2, tableName)
				.executeUpdate();
		logger.info(Constants.UPDATE_PARAMETRAGE_MESSAGE, tableName, update);
	}

	@Override
	public Integer getDiffLastDay(String tableName) throws NumberFormatException {
		Object domain = entityManager
				.createNativeQuery(QueryConstants.SQL_GET_DIFF_LAST_DAY + tableName)
				.getSingleResult();
		if(domain == null) {
			return null;
		}
		return Integer.parseInt(domain.toString());
	}
}
