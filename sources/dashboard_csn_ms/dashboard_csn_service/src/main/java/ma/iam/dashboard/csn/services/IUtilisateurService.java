package ma.iam.dashboard.csn.services;

import java.util.List;

import ma.iam.dashboard.csn.dtos.UtilisateurDto;

import org.springframework.http.ResponseEntity;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
public interface IUtilisateurService {
	
	UtilisateurDto getUserInformation();
	
	UtilisateurDto getCurrentUtilisateur();

	ResponseEntity<List<UtilisateurDto>> getUtilisateursByParam(String name);
}
