package ma.iam.dashboard.csn.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.iam.dashboard.csn.constants.QueryConstants;
import ma.iam.dashboard.csn.repository.IReferentielRepository;

@Repository
public class ReferentielRepositoryImpl implements IReferentielRepository{

    @Autowired
    private EntityManager entityManager;
    
	@SuppressWarnings("unchecked")
	public List<Object[]> getDrList() {
		return entityManager.createNativeQuery(QueryConstants.REQ_DR).getResultList();
	}
    
	@SuppressWarnings("unchecked")
	public List<Object[]> getDcByDr(Long idDr) {
		Query q = entityManager.createNativeQuery(QueryConstants.REQ_DC);
		q =	q.setParameter("dr", idDr);
		return q.getResultList();
	}
    
	@SuppressWarnings("unchecked")
	public List<Object[]> getFournisseurList(String typeEquipement) {
		return entityManager.createNativeQuery(QueryConstants.REQ_FOURNISSEUR).setParameter(1, typeEquipement).getResultList();
	}
}
