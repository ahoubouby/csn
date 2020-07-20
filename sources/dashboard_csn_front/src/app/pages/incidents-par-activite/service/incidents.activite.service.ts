import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../environments/environment';
import { IncidentOuverActivite } from '../../../model/IncidentOuverActivite';
import { Subject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class IncidentsActiviteService {
  constructor(private http: HttpClient) { }

  private subject = new Subject<boolean>();

  sendValue(value: boolean) {
    this.subject.next(value);
  }

  clearValue() {
    this.subject.next();
  }

  getValue(): Observable<boolean> {
    return this.subject.asObservable();
  }

  private back_url: string = environment.backend_url + 'services/admin';

  public get_back_url(): string {
    return this.back_url;
  }

  incidentsActiviteOuvertAdmin() {
    return this.http.get(this.back_url + '/incidentsActiviteOuvert');
  }
  updateIncident(incident: IncidentOuverActivite) {
    return this.http.post<IncidentOuverActivite>(this.back_url + '/incidentActiviteOuvert/', incident);
  }
}
