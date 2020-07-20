package ma.iam.dashboard.csn.repository;

import java.util.List;

public interface IReferentielRepository {

	List<Object[]> getDrList();
	
	List<Object[]> getDcByDr(Long idDr);
	
	List<Object[]> getFournisseurList(String typeEquipement);
}
