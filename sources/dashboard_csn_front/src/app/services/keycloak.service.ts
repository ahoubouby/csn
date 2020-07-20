import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import * as Keycloak from 'keycloak-js';
import { Observable, from } from 'rxjs';
/**
 * @author K.ELBAGUARI
 */
@Injectable({
  providedIn: 'root',
})
export class KeycloakService {
  private keycloakAuth: any;
  static auth: any = {};
  init(): Promise<any> {
    return new Promise((resolve, reject) => {
      const config = {
        url: environment.keycloakRootUrl,
        realm: environment.realm,
        clientId: environment.clientId,
      };
      KeycloakService.auth.loggedIn = false;
      this.keycloakAuth = Keycloak(config);
      this.keycloakAuth
        .init({ onLoad: 'login-required' })
        .success(() => {
          KeycloakService.auth.loggedIn = true;
          KeycloakService.auth.authz = this.keycloakAuth;
          KeycloakService.auth.logoutUrl =
            this.keycloakAuth.authServerUrl +
            'realms/' +
            environment.realm +
            '/protocol/openid-connect/logout?redirect_uri=' +
            document.baseURI;
          resolve();
        })
        .error(() => {
          reject();
        });
    });
  }
  static logout() {
    KeycloakService.auth.loggedIn = false;
    KeycloakService.auth.authz = null;

    window.location.href = KeycloakService.auth.logoutUrl;
  }
  static getUsername(): string {
    return KeycloakService.auth.authz.tokenParsed.preferred_username;
  }
  static getFullName(): string {
    return KeycloakService.auth.authz.tokenParsed.name;
  }
  getToken(): Promise<string> {
    return new Promise<string>((resolve, reject) => {
      if (KeycloakService.auth.authz.token) {
        KeycloakService.auth.authz
          .updateToken(environment.tokenRefreshTime)
          .success(() => {
            resolve(<string>KeycloakService.auth.authz.token);
          })
          .error(() => {
            KeycloakService.logout();
            reject('Failed to refresh token');
          });
      } else {
        KeycloakService.logout();
        reject('Not logged in');
      }
    });
  }

  isLoggedIn(): boolean {
    return KeycloakService.auth.authz.authenticated;
  }

  getUserToken() {
    const tokenPromise: Promise<string> = this.getToken();
    const tokenObservable: Observable<string> = from(tokenPromise);
    return tokenObservable;
  }

  getRolesRealm(): [] {
    if (KeycloakService.auth.authz.tokenParsed.realm_access !== undefined &&
       KeycloakService.auth.authz.tokenParsed.realm_access.roles !== undefined) {
      return KeycloakService.auth.authz.tokenParsed.realm_access.roles;
    }
  }

  getRolesRessource(): [] {
    const resource_access: any = KeycloakService.auth.authz.tokenParsed.resource_access;
    const clientId = environment.clientId;
    if (resource_access !== undefined) {
      for (const [key, value] of Object.entries(resource_access)) {
        if (key === clientId) {
          const client: any = value;
          return client.roles as [];
        }
      }
    }
    return [];
  }
}
