import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NgxPermissionsGuard } from 'ngx-permissions';
import { environment } from '../../../environments/environment';
import { IncidentsActiviteComponent } from './incidents.activite.component';
import { IncidentsOuvertsDialogComponent } from './incidents-ouverts-dialog/incidents-ouverts-dialog.component';
import {
  IncidentsOuvertsActiviteComponent,
  IncOuvCommentsButtonComponent,
} from './incidents-ouverts/incidents-ouverts.component';

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
  component: IncidentsActiviteComponent,
  children: [{
    path: 'incidents-ouverts',
    component: IncidentsOuvertsActiviteComponent,
    canActivate: [NgxPermissionsGuard],
    data: {
      permissions: createPermissionParam([environment.role_admin]),
    },
  }],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class IncidentsActiviteRoutingModule { }

export const routedComponents = [
  IncidentsActiviteComponent,
  IncidentsOuvertsActiviteComponent,
  // Comment
  IncOuvCommentsButtonComponent,
  IncidentsOuvertsDialogComponent,
];
