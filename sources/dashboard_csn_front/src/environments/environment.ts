/**
 * @license
 * Copyright Akveo. All Rights Reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.

export const environment = {
  production: false,
  keycloakRootUrl: 'https://localhost:9443/auth/',
  realm: 'salRealm',
  clientId: 'dashboard_csn',
  backend_url: 'http://localhost:8080/dashboard-csn-service/',
  apiKeyGoogle: 'AIzaSyDSSH-h-QWwXILol7nb923SqSlT4XGfGfM',
  tokenRefreshTime: 5, // minute
  role_central: 'DASHBOARD_CSN_CENTRAL',
  role_admin: 'DASHBOARD_CSN_ADMIN',
  keycloakRealmRolesDefault: 2,
  keycloakClientRolesDefault: 0,
};
