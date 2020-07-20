package ma.iam.dashboard.csn.services;

import java.util.List;

import ma.iam.dashboard.csn.dtos.IncidentActiviteAdminDto;


/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
public interface IAdminService {

	List<IncidentActiviteAdminDto> incidentsActiviteOuvert();	
	IncidentActiviteAdminDto incidentActiviteOuvert(IncidentActiviteAdminDto dto);	
	
}
