import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import {
  NbCardModule, NbSpinnerModule, NbButtonModule, NbInputModule, NbIconModule, NbSelectModule, NbDialogModule,
} from '@nebular/theme';
import { NgxUploaderModule } from 'ngx-uploader';
import { ThemeModule } from '../../@theme/theme.module';
import { FormsModule as ngFormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgxPermissionsModule } from 'ngx-permissions';
import { Ng2SmartTableModule } from 'ng2-smart-table';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { IncidentsActiviteRoutingModule, routedComponents } from './incidents.activite-routing.module';
import { IncOuvCommentsButtonComponent } from './incidents-ouverts/incidents-ouverts.component';
import { IncidentsOuvertsDialogComponent } from './incidents-ouverts-dialog/incidents-ouverts-dialog.component';
import { ConfirmationService, JasperoConfirmationsModule } from '@jaspero/ng-confirmations';
@NgModule({
  imports: [
    ThemeModule,
    IncidentsActiviteRoutingModule,
    ngFormsModule,
    ReactiveFormsModule,
    NbCardModule,
    NgxPermissionsModule.forChild(),
    Ng2SmartTableModule, // SmartTable
    NgbModule, // Pagination
    NbSpinnerModule,
    NbButtonModule,
    NbInputModule,
    NbIconModule,
    NbSelectModule,

    NbDialogModule.forChild(), // Dialog
    JasperoConfirmationsModule,
  ],
  exports: [NgxUploaderModule],
  declarations: [
    routedComponents,
  ],
  providers: [
    ConfirmationService,
  ],
  entryComponents: [
    IncOuvCommentsButtonComponent,
    IncidentsOuvertsDialogComponent,
  ],
  // Important pour SmartTable
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class IncidentsActiviteModule { }
