
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../environments/environment';

@Injectable({ providedIn: 'root' })
export class DashboardIncidentsService {
  private gs = environment;
  constructor(private http: HttpClient) { }

  getIncidentsOuvertFermeEnNombre() {
    return this.http.get(this.gs.backend_url + 'services/dashboardIncident/incidentsOuvertFermeEnNombre');
  }
  getIncidentsCiEtatSemaineParJour() {
    return this.http.get(this.gs.backend_url + 'services/dashboardIncident/incidentsCiEtatSemaineParJour');
  }
  getIncidentsCiOuvertActiviteSemaine() {
    return this.http.get(this.gs.backend_url + 'services/dashboardIncident/incidentsCiOuvertActiviteSemaine');
  }
  getIncidentsCiFermeActiviteSemaine() {
    return this.http.get(this.gs.backend_url + 'services/dashboardIncident/incidentsCiFermeActiviteSemaine');
  }
  getIncidentsCiOuvertDivisionSemaine() {
    return this.http.get(this.gs.backend_url + 'services/dashboardIncident/incidentsCiOuvertDivisionSemaine');
  }
  getIncidentsCiFermeDivisionSemaine() {
    return this.http.get(this.gs.backend_url + 'services/dashboardIncident/incidentsCiFermeDivisionSemaine');
  }
  getIncidentsCiOuvertParDirection() {
    return this.http.get(this.gs.backend_url + 'services/dashboardIncident/incidentsCiOuvertParDirection');
  }
  getIncidentsCiFermeParDirection() {
    return this.http.get(this.gs.backend_url + 'services/dashboardIncident/incidentsCiFermeParDirection');
  }
  getCumulDetails() {
    return this.http.get(this.gs.backend_url + 'services/dashboardIncident/cumulDetails');
  }
}
