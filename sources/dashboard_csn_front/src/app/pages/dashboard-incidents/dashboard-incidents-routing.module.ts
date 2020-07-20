import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NgxPermissionsGuard } from 'ngx-permissions';
import { environment } from '../../../environments/environment';
import { DashboardIncidentsComponent } from './dashboard-incidents.component';
/**
  *@author K.ELBAGUARI
  * NgxPermissionsGuard
 */
const noAuthRedirectTo = {
  navigationCommands: [''],
  navigationExtras: { skipLocationChange: true },
};
const createPermissionParam = (only) => {
  return {
    only: only,
    redirectTo: noAuthRedirectTo,
  };
};
const routes: Routes = [{
  path: '',
  component: DashboardIncidentsComponent,
  children: [
    {
      path: 'dashboard-incidents',
      component: DashboardIncidentsComponent,
      canActivate: [NgxPermissionsGuard],
      data: {
        permissions: createPermissionParam([environment.role_central]),
      },
    },

  ],
}];
@NgModule({
  imports: [
    RouterModule.forChild(routes),
  ],
  exports: [
    RouterModule,
  ],
})
export class DashboardIncidentsRoutingModule {

}
