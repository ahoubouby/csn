package ma.iam.dashboard.csn.controller;

import java.util.List;

import ma.iam.dashboard.csn.dtos.UtilisateurDto;
import ma.iam.dashboard.csn.services.IUtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author  K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
@CrossOrigin("*")
@RequestMapping("/services/user")
@RestController
public class UtilisateurController {

	@Autowired
	private IUtilisateurService utilisateurService;

	@GetMapping("/userInfos")
	public UtilisateurDto getUserInformation() {
		return utilisateurService.getUserInformation();
	}
	
	@GetMapping("/getCurrentUtilisateur")
	public UtilisateurDto getCurrentUtilisateur() {
		return utilisateurService.getCurrentUtilisateur();
	}

	@GetMapping("/getUtilisateursByParam")
	public ResponseEntity<List<UtilisateurDto>> getUtilisateursByParam(@RequestParam("param") String param) {
		return utilisateurService.getUtilisateursByParam(param);
	}
}