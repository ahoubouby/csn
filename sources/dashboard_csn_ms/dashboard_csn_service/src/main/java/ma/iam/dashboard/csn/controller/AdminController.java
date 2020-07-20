package ma.iam.dashboard.csn.controller;

import java.util.List;

import ma.iam.dashboard.csn.dtos.IncidentActiviteAdminDto;
import ma.iam.dashboard.csn.services.IAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author  K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
@CrossOrigin("*")
@RequestMapping("/services/admin")
@RestController
public class AdminController {

	@Autowired
	private IAdminService service;

	@GetMapping("/incidentsActiviteOuvert")
	public List<IncidentActiviteAdminDto> incidentsActiviteOuvert() {
		return service.incidentsActiviteOuvert();
	}
	
	@PostMapping("/incidentActiviteOuvert")
	public IncidentActiviteAdminDto incidentActiviteOuvert(@RequestBody IncidentActiviteAdminDto dto) {
		return service.incidentActiviteOuvert(dto);
	}
}
