import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { EquipementService } from '../../../services/equipement.service';
import { ReferentielsService } from '../../../services/referentiels.service';
import { Equipement } from '../../../model/Equipement';
import { FormBuilder } from '@angular/forms';
import {
  NbAccordionItemComponent,
} from '@nebular/theme';
import { MapStyleMorocco } from './mapStyle/mapStyle';
import { NgxPermissionsService } from 'ngx-permissions';
import { environment } from '../../../../environments/environment';
import { MapsAPILoader } from '@agm/core';
import { Fournisseur } from '../../../model/Fournisseur';
import { DC } from '../../../model/DC';
import { DR } from '../../../model/DR';
import { Synthese } from '../../../model/Synthese';


@Component({
  selector: 'ngx-gmaps',
  styleUrls: ['./gmaps.component.scss'],
  templateUrl: './gmaps.component.html',
})
export class GmapsComponent implements OnInit {
  formData: FormData;
  humanizeBytes: Function;
  dragOver: boolean;
  private static defaultLat = 28.7263795;
  private static defaultLng = -7.7871607;
  private static defaultZoom = 5;
  lat: Number;
  lng: Number;
  zoom: Number;
  vueSatellite: boolean;
  clusterMaxZoom = 1;
  showFilter = true;

  equipements: Equipement[];
  listDR: DR[] = [];
  // allDC = new Map<string, Set<string>>();
  listDC: DC[] = [];
  listFournisseurs: Fournisseur[] = [];
  listTypeEquipement: string[] = [];
  listTechnologies: string[] = [];
  selectDr = '';
  selectDc = '';
  showTechnologie: boolean;
  showMobile: boolean;

  tabSynthese: Synthese[];

  gmapFilterForm = this.fb.group({
    selectedDR: String,
    selectedDC: String,
    selectedFournisseur: String,
    selectedTypeEquipement: String,
    selectedTechnologie: String,
  });

  polylinesMaroc = [];
  style = [];
  @ViewChild('infoEquipement', { read: TemplateRef, static: true }) infoEquipementTemplate: TemplateRef<HTMLElement>;

  @ViewChild('filterItem', { static: false }) filterAccordion: NbAccordionItemComponent;
  editCancelStatus: string;
  isSelectMode: boolean;
  isCentral: boolean;
  filterLoaded: boolean = false;

  styles = [{
    height: 53,
    url: 'assets/images/m1.png',
    width: 52,
  },
  {
    height: 56,
    url: 'assets/images/m2.png',
    width: 55,
  },
  {
    height: 66,
    url: 'assets/images/m3.png',
    width: 65,
  },
  {
    height: 78,
    url: 'assets/images/m4.png',
    width: 77,
  },
  {
    height: 90,
    url: 'assets/images/m5.png',
    width: 89,
  },
  ];

  constructor(
    private equipementService: EquipementService,
    private referentielsService: ReferentielsService,
    public fb: FormBuilder,
    public mapStyle: MapStyleMorocco,
    private permissionsService: NgxPermissionsService,
    public mapsApiLoader: MapsAPILoader,
  ) {
    this.polylinesMaroc = this.mapStyle.polylinesMaroc;
    this.style = mapStyle.agmMapStyle;
    this.isSelectMode = true;
  }

  ngOnInit() {
    const isCentralRole = this.permissionsService.getPermissions().hasOwnProperty(environment.role_central);
    this.isCentral = isCentralRole;
    this.lat = GmapsComponent.defaultLat;
    this.lng = GmapsComponent.defaultLng;
    this.zoom = GmapsComponent.defaultZoom;
    this.editCancelStatus = 'primary';
    this.showTechnologie = true;
    this.showMobile = true;

    this.initForm();
    this.equipementService.getEquipementsByParams('', '', '', '', '')
      .subscribe(response => {
        this.handleSuccessfulResponseEquipement(response);
      });
    this.equipementService.getTab('')
      .subscribe(response => {
        this.handleSuccessfulResponseTab(response);
      });
  }


  initForm() {
    this.gmapFilterForm.get('selectedDC').setValue(this.selectDr, { onlySelf: true });
    this.gmapFilterForm.get('selectedFournisseur').patchValue('');
    this.initListDr();
    this.initListFourniseur('');
    this.initListTypeEquipement();
    this.initListTechnologie();
  }

  initListDr() {
    this.gmapFilterForm.get('selectedDR').setValue(this.selectDr, { onlySelf: true });
    this.referentielsService.getListDR().subscribe(
      response => this.handleSuccessfulResponseListDR(response),
    );
    this.initListDc();
  }

  initListDc() {
    this.listDC = [];
  }

  initListFourniseur(typeEquipement: String) {
    this.referentielsService.getListFournisseur(typeEquipement).subscribe(
      response => this.handleSuccessfulResponseListFournisseur(response),
    );
  }

  initListTypeEquipement() {
    this.listTypeEquipement = ['MSAN'];
    this.gmapFilterForm.get('selectedTypeEquipement').patchValue('');
  }

  initListTechnologie() {
    this.gmapFilterForm.get('selectedTechnologie').patchValue('');
    // this.referentielsService.getListTechnologie().subscribe(
    //   response => this.handleSuccessfulResponseListTechnologie(response),
    // );
    this.listTechnologies = ['2G', '3G', '4G'];

  }

  // initSelectDr() {
  //   this.initSelectDc();
  //   this.gmapFilterForm.get('selectedDR').setValue(this.selectDr, { onlySelf: true });
  // }

  // initSelectDc() {
  //   this.gmapFilterForm.get('selectedDC').setValue(this.selectDc, { onlySelf: true });
  //   if (this.userHasDr && !this.userHasDc && this.selectDr !== null) {
  //     this.referentielsService.getListDC(this.selectDr).subscribe(
  //       response => this.handleSuccessfulResponseListDC(response),
  //     );
  //   } else {
  //     this.listDC = [];
  //   }
  // }

  // initSelectFournisseur() {
  //   this.gmapFilterForm.get('selectedFournisseur').patchValue('');
  //   this.listFournisseurs = [];
  // }
  // initSelectTechnologie() {
  //   this.gmapFilterForm.get('selectedTechnologie').patchValue('');
  //   this.listTechnologies = [];
  // }

  getMarkerIcon() {
    return this.showMobile
      ? './assets/images/marker_rouge.png'
      : './assets/images/msan.png';
  }

  changeDR(e: any) {
    this.gmapFilterForm.get('selectedDC').setValue(this.selectDc, { onlySelf: true });
    this.listDC = [];
    const selected: string = this.gmapFilterForm.get('selectedDR').value;
    if (selected != null && selected !== '') {
      this.referentielsService.getListDC(selected).subscribe(
        response => this.handleSuccessfulResponseListDC(response),
      );
    }

  }
  changeType(e: any) {
    let selected: string = this.gmapFilterForm.get('selectedTypeEquipement').value;
    if (selected == null) {
      selected = '';
    }
    this.showTechnologie = (selected === '');
    this.gmapFilterForm.get('selectedFournisseur').patchValue('');
    this.initListFourniseur(selected);
  }

  handleSuccessfulResponseListDR(response: DR[]) {
    this.listDR = response;
  }

  handleSuccessfulResponseListDC(response: DC[]) {
    this.listDC = response;
  }


  handleSuccessfulResponseListFournisseur(response: Fournisseur[]) {
    this.listFournisseurs = response;
  }
  handleSuccessfulResponseListTechnologie(response: string[]) {
    this.listTechnologies = response;
  }

  handleSuccessfulResponseEquipement(response: Equipement[]) {
    this.equipements = response;
    this.locateMap();
    // this.showFilter = true;
    // this.initForm();
  }

  handleSuccessfulResponseTab(response: Synthese[]) {
    this.tabSynthese = response;
  }

  locateMap() {
    if (this.equipements.length > 0) {
      this.lat = GmapsComponent.defaultLat;
      this.lng = GmapsComponent.defaultLng;
      this.zoom = GmapsComponent.defaultZoom;
      let minLat = Number.parseFloat(this.equipements[0].latitude),
        maxLat = Number.parseFloat(this.equipements[0].latitude),
        minLng = Number.parseFloat(this.equipements[0].longitude),
        maxLng = Number.parseFloat(this.equipements[0].longitude);
      this.equipements.forEach(e => {
        const lat = Number.parseFloat(e.latitude);
        const lng = Number.parseFloat(e.longitude);
        if (lat < minLat) {
          minLat = lat;
        }
        if (lat > maxLat) {
          maxLat = lat;
        }
        if (lng < minLng) {
          minLng = lng;
        }
        if (lng > maxLng) {
          maxLng = lng;
        }
      });
      this.lat = (minLat + maxLat) / 2;
      this.lng = (minLng + maxLng) / 2;
      this.zoom = GmapsComponent.defaultZoom;
    }
  }

  onSubmitFilter() {
    this.loadFilter();
  }

  private loadFilter() {
    const selectedDR: String = this.gmapFilterForm.get('selectedDR').value;
    const selectedDC: String = this.gmapFilterForm.get('selectedDC').value;
    const selectedFournisseur: String = this.gmapFilterForm.get('selectedFournisseur').value;
    const selectedTypeEquipement: String = this.gmapFilterForm.get('selectedTypeEquipement').value;
    const selectedTechnologie: String = this.gmapFilterForm.get('selectedTechnologie').value;
    this.filterLoaded = true;
    this.equipementService.getEquipementsByParams(
      selectedDR, selectedDC,
      selectedFournisseur,
      selectedTypeEquipement,
      selectedTechnologie,
    )
      .subscribe(response => {
        this.handleSuccessfulResponseEquipement(response);
        this.showMobile = (selectedTypeEquipement == null || selectedTypeEquipement === '');
      });

    this.equipementService.getTab(selectedTypeEquipement)
      .subscribe(response => this.handleSuccessfulResponseTab(response),
      );
  }

  toggleCluster(e: any) {
    this.clusterMaxZoom = e ? 0 : 1;
    // this.zoom = 2;
    // // this.locateMap();
    // setTimeout(() => {
    //   this.zoom = GmapsComponent.defaultZoom;
    // }, 300);
  }

  clusterCalculator(markers, numStyles) {
    const count = markers.length;
    let clusterIndex: number;
    switch (true) {
      case (count < 5): clusterIndex = 1; break;
      case (count < 10): clusterIndex = 2; break;
      case (count < 20): clusterIndex = 3; break;
      case (count < 40): clusterIndex = 4; break;
      default: clusterIndex = 5; break;
    }
    return {
      text: count,
      index: clusterIndex,
    };
  }

}
