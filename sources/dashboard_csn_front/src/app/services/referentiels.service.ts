import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { DR } from '../model/DR';
import { DC } from '../model/DC';
import { Observable } from 'rxjs';
import { Fournisseur } from '../model/Fournisseur';

@Injectable({
  providedIn: 'root',
})
export class ReferentielsService {
  constructor(private http: HttpClient) {
  }

  private back_url: string = environment.backend_url + 'services/referentiel';

  public get_back_url(): string {
    return this.back_url;
  }

  getListDR() {
    return this.http.get<Array<DR>>(this.back_url + '/getAllDr');
  }

  getListDC(id: String) {
    if (id == null || id === '') {
      return new Observable<Array<DC>>();
    }
    return this.http.get<Array<DC>>(this.back_url + '/getAllDcByDr?idtDr=' + id);
  }

  getListFournisseur(typeEquipement: String) {
    return this.http.get<Array<Fournisseur>>(this.back_url + '/getFournisseurs?typeEquipement=' + typeEquipement);
  }

  // getListTechnologie() {
  //   return this.http.get<Array<Technologie>>(this.back_url + '/getAllTechnologie');
  // }
}
