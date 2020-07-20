package ma.iam.dashboard.csn.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import ma.iam.dashboard.csn.repository.IIncidentRepository;
/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
@Repository
public class IncidentRepositoryImpl implements IIncidentRepository {

    @Autowired
    private EntityManager entityManager;
    
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> equipementsHS(String dr, String dc, String fournisseur, String typeEquipement, String technologie) {
		String tableName = "Req" 
				+ (StringUtils.isEmpty(typeEquipement)  
					? "Equip" + (technologie == null ? "" : technologie) 
					: typeEquipement);
		
		String sql = "Select * from " + tableName;	
		String sqlWhere = " WHERE 1=1"; 
		if(!StringUtils.isEmpty(dr)) {
			sqlWhere += " AND :dr = iddr";
		}
		if(!StringUtils.isEmpty(dc)) {
			sqlWhere += " AND :dc = iddc";
		}
		if(!StringUtils.isEmpty(fournisseur)) {
			sqlWhere += " AND :fournisseur = idfournisseur";
		}
		sql = sql.toLowerCase();
		sql += sqlWhere;
		Query q = entityManager.createNativeQuery(sql);
		if(!StringUtils.isEmpty(dr)) {
			q =	q.setParameter("dr", dr);
		}
		if(!StringUtils.isEmpty(dc)) {
			q =	q.setParameter("dc", dc);
		}
		if(!StringUtils.isEmpty(fournisseur)) {
			q =	q.setParameter("fournisseur", fournisseur);
		}
		return q.getResultList();
	           
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> tab_equip(String typeEquipement){
		String tableName = "req_stat_" 
				+ (StringUtils.isEmpty(typeEquipement)  
					? "mbts"
					: typeEquipement);
		
		String sql = "Select * from " + tableName;	
		String sqlWhere = " WHERE 1=1"; 
		
		sql = sql.toLowerCase();
		sql += sqlWhere;
		Query q = entityManager.createNativeQuery(sql);
		return q.getResultList();
	}
}
