package ma.iam.dashboard.csn.repository;

import java.util.List;
/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
public interface IIncidentRepository {	

	List<Object[]> equipementsHS(String dr, String dc, String fournisseur, String typeEquipement, String technologie);	

	List<Object[]> tab_equip(String typeEquipement);	
}
