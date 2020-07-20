import { Component } from '@angular/core';
import { NbUserComponent } from '@nebular/theme';
import { KeycloakService } from '../../../services/keycloak.service';

/**
 * @author K.ELBAGUARI && O.SLAAOUITER
 */
@Component({
  selector: 'ngx-custom-user',
  styleUrls: ['./custom-user.component.scss'],
  templateUrl: './custom-user.component.html',
})
export class CustomUserComponent extends NbUserComponent {
  logoutApp() {
    KeycloakService.logout();
  }
}
