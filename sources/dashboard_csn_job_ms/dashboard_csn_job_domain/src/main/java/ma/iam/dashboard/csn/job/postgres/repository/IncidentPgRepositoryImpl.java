package ma.iam.dashboard.csn.job.postgres.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ma.iam.dashboard.csn.job.postgres.constants.QueryConstants;
/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
@Repository
public class IncidentPgRepositoryImpl implements IIncidentPgRepository {

    @Autowired
    @Qualifier("pgEntityManagerFactory")
    private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> incidentsOuvertFermeEnNombre() {
		return entityManager.createNativeQuery(QueryConstants.QUERY_INCIDENTS_OUVERT_FERME).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> incidentsCiEtatSemaineParJour(Integer diffDays) {
		Query q = entityManager.createNativeQuery(QueryConstants.QUERY_INCIDENTS_CI_ETAT_SEMAINE)
				.setParameter(1, diffDays);
		if(QueryConstants.REQ2_USE_SECOND_PARAM) {
			q.setParameter(2, diffDays);
		}
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> incidentsCiOuvertDivisionSemaine(Integer diffDays) {
		return entityManager.createNativeQuery(QueryConstants.QUERY_INCIDENTS_CI_DIVISION_OUVERT).setParameter(1, diffDays).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> incidentsCiFermeDivisionSemaine(Integer diffDays) {
		return entityManager.createNativeQuery(QueryConstants.QUERY_INCIDENTS_CI_DIVISION_FERME).setParameter(1, diffDays).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> incidentsCiOuvertActiviteSemaine(Integer diffDays) {
		return entityManager.createNativeQuery(QueryConstants.QUERY_INCIDENTS_CI_ACTIVITE_OUVERT).setParameter(1, diffDays).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> incidentsCiFermeActiviteSemaine(Integer diffDays) {
		return entityManager.createNativeQuery(QueryConstants.QUERY_INCIDENTS_CI_ACTIVITE_FERME).setParameter(1, diffDays).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> equipementsHS() {	
		return entityManager.createNativeQuery(QueryConstants.QUERY_INCIDENTS_EQUIP).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> equipements2gHS() {
		return entityManager.createNativeQuery(QueryConstants.QUERY_INCIDENTS_EQUIP_2G).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> equipements3gHS() {
		return entityManager.createNativeQuery(QueryConstants.QUERY_INCIDENTS_EQUIP_3G).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> equipements4gHS() {
		return entityManager.createNativeQuery(QueryConstants.QUERY_INCIDENTS_EQUIP_4G).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> msan() {
		return entityManager.createNativeQuery(QueryConstants.QUERY_INCIDENTS_MSAN).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> dr(){
		return entityManager.createNativeQuery(QueryConstants.QUERY_INCIDENTS_DR).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> dc() {
		return entityManager.createNativeQuery(QueryConstants.QUERY_INCIDENTS_DC).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> fournisseur() {
		return entityManager.createNativeQuery(QueryConstants.QUERY_INCIDENTS_FOURNISSEUR).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> statMbts() {
		return entityManager.createNativeQuery(QueryConstants.SQL_TAB_MBTS).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> statMsan() {
		return entityManager.createNativeQuery(QueryConstants.SQL_TAB_MSAN).getResultList();
	}
}
