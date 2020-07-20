import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';

import { ThemeModule } from '../../@theme/theme.module';
import { NgxPermissionsModule, NgxPermissionsService } from 'ngx-permissions';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ChartModule } from 'angular2-chartjs';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { NgxEchartsModule } from 'ngx-echarts';
import { NbAccordionModule, NbCardModule } from '@nebular/theme';
import { DashboardIncidentsComponent } from './dashboard-incidents.component';
import { DashboardIncidentsRoutingModule } from './dashboard-incidents-routing.module';
import { RandomcolorModule } from 'angular-randomcolor';
import { ChartIncidentsCiEtatParSemaineComponent } from './charts/chart-incidents-ci-etat-semaine-par-jour.component';
import { ChartIncidentsCiOuvertDivisionComponent } from './charts/chart-incidents-ci-ouvert-division.component';
import { ChartIncidentsCiFermeDivisionComponent } from './charts/chart-incidents-ci-ferme-division.component';
import { ChartIncidentsCiOuvertActiviteComponent } from './charts/chart-incidents-ci-ouvert-activite.component';
import { ChartIncidentsCiFermeActiviteComponent } from './charts/chart-incidents-ci-ferme-activite.component';
import { ChartIncidentsOuvertFermeNombreComponent } from './charts/chart-incidents-ouvert-ferme-nombre.component';
import { ChartIncidentsCiOuvertDirectionComponent } from './charts/chart-incidents-ci-ouvert-direction.component';
import { ChartIncidentsCiFermeDirectionComponent } from './charts/chart-incidents-ci-ferme-direction.component';

const APP_PROVIDERS = [
  NgxPermissionsService,
];
export const components = [
  DashboardIncidentsComponent,
  ChartIncidentsCiEtatParSemaineComponent,
  ChartIncidentsCiOuvertDivisionComponent,
  ChartIncidentsCiFermeDivisionComponent,
  ChartIncidentsCiOuvertActiviteComponent,
  ChartIncidentsCiFermeActiviteComponent,
  ChartIncidentsOuvertFermeNombreComponent,
  ChartIncidentsCiOuvertDirectionComponent,
  ChartIncidentsCiFermeDirectionComponent,
];
@NgModule({
  imports: [
    DashboardIncidentsRoutingModule,
    NgxPermissionsModule.forChild(),
    CommonModule,
    FormsModule,
    NgbModule,
    ThemeModule,
    NgxEchartsModule,
    NgxChartsModule,
    ChartModule,
    NbAccordionModule,
    NbCardModule,
    RandomcolorModule,

  ],
  declarations: [
    ...components,
  ],
  providers: [APP_PROVIDERS,
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class DashboardIncidentsModule { }
