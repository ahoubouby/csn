package ma.iam.dashboard.csn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.iam.dashboard.csn.dtos.DcDto;
import ma.iam.dashboard.csn.dtos.DrDto;
import ma.iam.dashboard.csn.dtos.FournisseurDto;
import ma.iam.dashboard.csn.services.IReferentielService;

/**
 * 
 * @author  K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
@CrossOrigin("*")
@RequestMapping("/services/referentiel")
@RestController
public class ReferentielController {

	@Autowired
	private IReferentielService referentielService;
	
	@GetMapping("/getAllDr")
    public List<DrDto> getAllDr() {
		return referentielService.getAllDr();
    }
	
	@GetMapping("/getAllDcByDr")
    public List<DcDto> getAllDcByDr(@RequestParam("idtDr") Long idtDr) {
		return referentielService.getAllDcByDr(idtDr);
    }
	
	@GetMapping("/getFournisseurs")
    public List<FournisseurDto> getFournisseurs(@RequestParam("typeEquipement") String typeEquipement) {
		return referentielService.getFournisseurs(typeEquipement);
    }
	
}
