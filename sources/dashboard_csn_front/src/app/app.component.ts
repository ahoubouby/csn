/**
 * @license
 * Copyright Akveo. All Rights Reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
import { Component, OnInit } from '@angular/core';
import { AnalyticsService } from './@core/utils/analytics.service';
import { NgxPermissionsService } from 'ngx-permissions';
import { KeycloakService } from './services/keycloak.service';
import { environment } from '../environments/environment';
/**
 * @author K.ELBAGUARI
 * NgxPermissions
 * JwtHelper
 */
@Component({
  selector: 'ngx-app',
  template: '<router-outlet></router-outlet>',
})
export class AppComponent implements OnInit {

  constructor(
    private permissionsService: NgxPermissionsService,
    private analytics: AnalyticsService,
    private keycloakService: KeycloakService,
  ) {
    const keycloakRealmRolesDefault = environment.keycloakRealmRolesDefault;
    const keycloakClientRolesDefault = environment.keycloakClientRolesDefault;
    const roles = [];
    const rolesRealm = this.keycloakService.getRolesRealm();
    const rolesRessource = this.keycloakService.getRolesRessource();
    if (rolesRealm !== undefined && rolesRealm !== null && rolesRealm.length > keycloakRealmRolesDefault) {
      rolesRealm.forEach(r => {
        if (r !== 'uma_authorization' && r !== 'offline_access') {
          roles.push(r);
        }
      });
    }
    if (rolesRessource !== undefined && rolesRessource !== null &&
      rolesRessource.length > keycloakClientRolesDefault) {
      roles.push(...rolesRessource);
    }
    if (roles !== undefined && roles !== null && roles.length > 0) {
      this.permissionsService.loadPermissions(roles);
    } else {
      KeycloakService.logout();
    }
  }
  ngOnInit() {
    this.analytics.trackPageViews();
  }
}
