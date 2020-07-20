package ma.iam.dashboard.csn.repository;

import java.util.List;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
public interface IAdminRepository {	
	List<Object[]> incidentsActiviteOuvert();
	Object[] incidentActiviteOuvert(String commentaire, String jour, String activite);
}
