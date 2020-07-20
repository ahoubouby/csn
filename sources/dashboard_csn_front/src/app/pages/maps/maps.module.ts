import { NgModule } from '@angular/core';
import { AgmCoreModule } from '@agm/core';
import {
  NbActionsModule,
  NbButtonModule,
  NbCardModule,
  NbInputModule,
  NbSelectModule,
  NbDialogModule,
  NbAlertModule,
  NbAccordionModule,
  NbIconModule,
  NbListModule,
  NbToggleModule,
  NbSpinnerModule,
} from '@nebular/theme';
import { NgxUploaderModule } from 'ngx-uploader';
import { ThemeModule } from '../../@theme/theme.module';
import { MapsRoutingModule, routedComponents } from './maps-routing.module';
import { FormsModule as ngFormsModule, ReactiveFormsModule } from '@angular/forms';
import { MapStyleMorocco } from './gmaps/mapStyle/mapStyle';
import { NgxPermissionsModule } from 'ngx-permissions';
import { environment } from '../../../environments/environment';
import { AgmJsMarkerClustererModule } from '@agm/js-marker-clusterer';
@NgModule({
  imports: [
    ThemeModule,
    AgmCoreModule.forRoot({
      apiKey: environment.apiKeyGoogle,
      libraries: ['places'],
    }),
    AgmJsMarkerClustererModule,
    NbDialogModule.forChild(),
    MapsRoutingModule,
    NbActionsModule,
    NbButtonModule,
    NbCardModule,
    NbInputModule,
    NbSelectModule,
    ngFormsModule,
    ReactiveFormsModule,
    NbAlertModule,
    NbAccordionModule,
    NbIconModule,
    NgxUploaderModule,
    NbListModule,
    NbToggleModule,
    NgxPermissionsModule.forChild(),
    NbSpinnerModule,
  ],
  exports: [NgxUploaderModule],
  declarations: [
    ...routedComponents,
  ],
  providers: [
    MapStyleMorocco,
  ],
})
export class MapsModule { }
