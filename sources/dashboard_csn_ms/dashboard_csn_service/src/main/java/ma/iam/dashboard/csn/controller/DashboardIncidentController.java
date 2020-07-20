package ma.iam.dashboard.csn.controller;

import java.util.List;

import ma.iam.dashboard.csn.dtos.CumulDetailDto;
import ma.iam.dashboard.csn.dtos.DashIncidentActiviteParentDto;
import ma.iam.dashboard.csn.dtos.DashIncidentCiEtatSemaineParJourParentDto;
import ma.iam.dashboard.csn.dtos.DashIncidentDateParentDto;
import ma.iam.dashboard.csn.dtos.DashIncidentNameParentDto;
import ma.iam.dashboard.csn.dtos.DashbIncidentOuvertFermeDto;
import ma.iam.dashboard.csn.services.IDashboardIncidentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author  K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
@CrossOrigin("*")
@RequestMapping("/services/dashboardIncident")
@RestController
public class DashboardIncidentController {

	@Autowired
	private IDashboardIncidentService service;

/*	@GetMapping("/incidentsTraitesParSemaine")
	public List<DashboardIncidentTraiteDto> incidentsTraitesParSemaine() {
		return service.incidentsTraitesParSemaine();
	}
	@GetMapping("/ciDerangementParActivite")
	public List<DashboardIncidentEnCoursDto> ciDerangementParActivite() {
		return service.ciDerangementParActivite();
	}

	@GetMapping("/ciDerangementParRegion")
	public List<DashboardIncidentEnCoursDto> ciDerangementParRegion() {
		return service.ciDerangementParRegion();
	}

	@GetMapping("/incidentsFermesParDivisionEnSemaine")
	public List<DashboardIncidentDateDto> incidentsFermesParDivisionEnSemaine() {
		return service.incidentsFermesParDivisionEnSemaine();
	}
	@GetMapping("/incidentsFermesParActiviteEnSemaine")
	public List<DashboardIncidentDateDto> incidentsFermesParActiviteEnSemaine() {
		return service.incidentsFermesParActiviteEnSemaine();
	}*/
	@GetMapping("/incidentsCiEtatSemaineParJour")
	public List<DashIncidentCiEtatSemaineParJourParentDto> incidentsCiEtatSemaineParJour() {
		return service.incidentsCiEtatSemaineParJour();
	}
//	@GetMapping("/incidentsCiEtatJourParHeure")
//	public List<DashIncidentCiEtatJourParHeureParentDto> incidentsCiEtatJourParHeure() {
//		return service.incidentsCiEtatJourParHeure();
//	}
	@GetMapping("/incidentsCiOuvertDivisionSemaine")
	public List<DashIncidentDateParentDto> incidentsCiOuvertDivisionSemaine() {
		return service.incidentsCiOuvertDivisionSemaine();
	}
	@GetMapping("/incidentsCiFermeDivisionSemaine")
	public List<DashIncidentDateParentDto> incidentsCiFermeDivisionSemaine() {
		return service.incidentsCiFermeDivisionSemaine();
	}
	
	@GetMapping("/incidentsCiOuvertParDirection")
	public List<DashIncidentNameParentDto> incidentsCiOuvertParDirection() {
		return service.incidentsCiOuvertParDirection();
	}
	@GetMapping("/incidentsCiFermeParDirection")
	public List<DashIncidentNameParentDto> incidentsCiFermeParDirection() {
		return service.incidentsCiFermeParDirection();
	}
	@GetMapping("/incidentsCiOuvertActiviteSemaine")
	public List<DashIncidentActiviteParentDto> incidentsCiOuvertActiviteSemaine() {
		return service.incidentsCiOuvertActiviteSemaine();
	}
	@GetMapping("/incidentsCiFermeActiviteSemaine")
	public List<DashIncidentDateParentDto> incidentsCiFermeActiviteSemaine() {
		return service.incidentsCiFermeActiviteSemaine();
	}
	@GetMapping("/incidentsOuvertFermeEnNombre")
	public List<DashbIncidentOuvertFermeDto> incidentsOuvertFermeEnNombre() {
		return service.incidentsOuvertFermeEnNombre();
	}
	@GetMapping("/cumulDetails")
	public CumulDetailDto cumulDetails() {
		return service.cumulDetails();
	}
}
