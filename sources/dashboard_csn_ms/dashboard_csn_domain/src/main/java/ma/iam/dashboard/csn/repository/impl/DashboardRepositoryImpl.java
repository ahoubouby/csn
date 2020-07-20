package ma.iam.dashboard.csn.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.iam.dashboard.csn.constants.QueryConstants;
import ma.iam.dashboard.csn.repository.IDashboardRepository;

@Repository
public class DashboardRepositoryImpl implements IDashboardRepository {

	@Autowired
	private EntityManager entityManager;

//	@SuppressWarnings("unchecked")
//	public List<Object[]> incidentsTraitesParSemaine() {
//		String sql = "Select * from \"Req1\"";
//		return entityManager.createNativeQuery(sql).getResultList();
//	}
	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Object[]> ciDerangementParActivite() {
//		String sql = "Select * from \"Req2\"";
//		return entityManager.createNativeQuery(sql).getResultList();
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Object[]> ciDerangementParRegion() {
//		String sql = "Select * from \"Req3\"";
//		return entityManager.createNativeQuery(sql).getResultList();
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Object[]> incidentsFermesParDivisionEnSemaine() {
//		String sql = "Select * from \"Req4\"";
//		return entityManager.createNativeQuery(sql).getResultList();
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Object[]> incidentsFermesParActiviteEnSemaine() {
//		String sql = "Select * from \"Req5\"";
//		return entityManager.createNativeQuery(sql).getResultList();
//	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Object[]> incidentsCiEtatJourParHeure() {
//		String sql = "Select * from req1";
//		return entityManager.createNativeQuery(sql).getResultList();
//	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> incidentsCiEtatSemaineParJour() {
		return entityManager.createNativeQuery(QueryConstants.REQ_INCIDENT_ETAT_SEMAINE).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> incidentsCiOuvertDivisionSemaine() {
		return entityManager.createNativeQuery(QueryConstants.REQ_INCIDENT_DIRECTION_OUVERT).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> incidentsCiFermeDivisionSemaine() {
		return entityManager.createNativeQuery(QueryConstants.REQ_INCIDENT_DIRECTION_FERME).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> incidentsCiOuvertActiviteSemaine() {
		return entityManager.createNativeQuery(QueryConstants.REQ_INCIDENT_ACTIVITE_OUVERT).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> incidentsCiFermeActiviteSemaine() {
		return entityManager.createNativeQuery(QueryConstants.REQ_INCIDENT_ACTIVITE_FERME).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> incidentsOuvertFermeEnNombre() {
		return entityManager.createNativeQuery(QueryConstants.REQ_INCIDENT_CUMUL).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object cumulDetails() {
		List<Object> result = entityManager.createNativeQuery(QueryConstants.REQ_INCIDENT_CUMUL_DETAILS).getResultList();
		if(result != null && result.size() > 0 ) {
			return result.get(0);
		}
		return null;
	}

}
