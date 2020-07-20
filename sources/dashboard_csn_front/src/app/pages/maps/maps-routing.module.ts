import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { MapsComponent } from './maps.component';
import { GmapsComponent } from './gmaps/gmaps.component';
import { NgxPermissionsGuard } from 'ngx-permissions';
import { environment } from '../../../environments/environment';
import { SlideOutComponent } from './gmaps/slide-out/slide-out.component';
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
  component: MapsComponent,
  children: [{
    path: 'gmaps',
    component: GmapsComponent,
    canActivate: [NgxPermissionsGuard],
    data: {
      permissions: createPermissionParam([environment.role_central]),
    },
  }],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class MapsRoutingModule { }

export const routedComponents = [
  MapsComponent,
  GmapsComponent,
  SlideOutComponent,
];
