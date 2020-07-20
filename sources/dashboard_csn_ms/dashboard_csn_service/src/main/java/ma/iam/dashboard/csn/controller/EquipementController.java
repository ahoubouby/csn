package ma.iam.dashboard.csn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.iam.dashboard.csn.dtos.EquipementDto;
import ma.iam.dashboard.csn.dtos.MapParam;
import ma.iam.dashboard.csn.dtos.SyntheseDto;
import ma.iam.dashboard.csn.services.IEquipementService;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
@CrossOrigin("*")
@RequestMapping("/services/equipement")
@RestController
public class EquipementController {

	@Autowired
	private IEquipementService equipementService;

	@PostMapping("/equipementsByParams")
	List<EquipementDto> getEquipementParams(@RequestBody MapParam params) {
		List<EquipementDto> equipements = equipementService.getListEquipementsByParams
				(params.getDr(), params.getDc(), params.getFournisseur(), params.getTypeEquipement(), params.getTechnologie());
		return equipements;
	}

	@GetMapping("/equipementsTab")
	List<SyntheseDto> getEquipementParams(@RequestParam("typeEquipement") String typeEquipement) {
		return equipementService.getTabSyntheseEquipement(typeEquipement);
	}
}