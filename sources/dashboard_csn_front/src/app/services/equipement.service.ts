import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Equipement } from '../model/Equipement';
import { environment } from '../../environments/environment';
import { Synthese } from '../model/Synthese';

@Injectable({
  providedIn: 'root',
})
export class EquipementService {
  constructor(private http: HttpClient) {
  }

  private back_url: string = environment.backend_url + 'services/equipement';

  public get_back_url(): string {
    return this.back_url;
  }
  getEquipementsByParams(dr: String, dc: String, fournisseur: String, typeEquipement: String, technologie: String) {
    return this.http.post<Array<Equipement>>(this.back_url + '/equipementsByParams/',
      {
        dr: dr,
        dc: dc,
        fournisseur: fournisseur,
        typeEquipement: typeEquipement,
        technologie: technologie,
      });
  }

  getTab(typeEquipement: String) {
    return this.http.get<Array<Synthese>>(this.back_url + '/equipementsTab?typeEquipement=' + typeEquipement);
  }

}
