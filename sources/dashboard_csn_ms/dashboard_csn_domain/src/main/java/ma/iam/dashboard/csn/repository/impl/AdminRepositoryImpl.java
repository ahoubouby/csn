package ma.iam.dashboard.csn.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import ma.iam.dashboard.csn.constants.QueryConstants;
import ma.iam.dashboard.csn.repository.IAdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
@Repository
public class AdminRepositoryImpl implements IAdminRepository {

	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> incidentsActiviteOuvert() {
		return entityManager.createNativeQuery(QueryConstants.REQ_INCIDENT_ACTIVITE_OUVERT_LIST_COMMENTAIRE).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] incidentActiviteOuvert(String commentaire, String jour, String activite) {
		Object[] domain = null;
		jour += "%";
		int update = entityManager.createNativeQuery(QueryConstants.REQ_UPDATE_COMMENTAIRE)
					.setParameter(1, commentaire)
					.setParameter(2, jour)
					.setParameter(3, activite)
					.executeUpdate();
		if(update == 1){
			List<Object[]> domains = entityManager.createNativeQuery(QueryConstants.REQ_INCIDENT_ACTIVITE_OUVERT_FOR_COMMENTAIRE)
					.setParameter(1, jour)
					.setParameter(2, activite)
					.getResultList();
			if(domains != null && domains.size() > 0){
				domain = domains.get(0);
			}
		}
		return domain;
		
	}
}
