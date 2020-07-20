/**
 * @license
 * Copyright Akveo. All Rights Reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
export const environment = {
  production: true,
  keycloakRootUrl: 'https://sal-keycloak.k8s-dev.iamdg.net.ma/auth/',
  realm: 'aggcRealm',
  clientId: 'dashboard_csn',
  backend_url: 'https://dashboard-csn-int.k8s-dev.iamdg.net.ma/dashboard_csn_ms/',
  apiKeyGoogle: 'AIzaSyDSSH-h-QWwXILol7nb923SqSlT4XGfGfM',
  tokenRefreshTime: 5, // minute
  role_central: 'DASHBOARD_CSN_CENTRAL',
  role_admin: 'DASHBOARD_CSN_ADMIN',
  keycloakRealmRolesDefault: 2,
  keycloakClientRolesDefault: 0,
};
