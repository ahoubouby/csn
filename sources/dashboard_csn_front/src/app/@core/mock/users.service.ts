import { of as observableOf, Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { UserData } from '../data/users';
import { KeycloakService } from '../../services/keycloak.service';

/**
 * @author K.ELBAGUARI && O.SLAAOUITER
 */
@Injectable()
export class UserService extends UserData {

  private users = {
    loggedUer: {
      name: (KeycloakService.getFullName() !== undefined) ?
        KeycloakService.getFullName() : KeycloakService.getUsername(),
      picture: 'assets/images/logout.png',
    },
  };

  getUsers(): Observable<any> {
    return observableOf(this.users);
  }
}
