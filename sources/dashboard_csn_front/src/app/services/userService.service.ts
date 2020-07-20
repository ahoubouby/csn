import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {
  }

  private back_url: string = environment.backend_url + 'services/user';

  public get_back_url(): string {
    return this.back_url;
  }

  getCurrentUtilisateur() {
    return this.http.get<User>(this.back_url + '/getCurrentUtilisateur');
  }

  getUsersByParam(param: string) {
    return this.http.get<Array<User>>(this.back_url + '/getUtilisateursByParam?param=' + param);
  }

}
