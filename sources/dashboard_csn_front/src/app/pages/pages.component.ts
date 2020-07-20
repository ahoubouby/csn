import { Component, OnInit } from '@angular/core';
import { NgxPermissionsService } from 'ngx-permissions';
import { MENU_ITEMS_CENTRAL, MENU_ITEMS_ADMIN, MENU_ITEMS_ALL } from './pages-menu';
import { Router } from '@angular/router';
import { environment } from '../../environments/environment';
@Component({
  selector: 'ngx-pages',
  styleUrls: ['pages.component.scss'],
  templateUrl: './pages.component.html',
})
/**
 * @author K.ELBAGUARI
 * NgxPermissions
 */
export class PagesComponent implements OnInit {
  menu = [];
  redirectUrl = '';
  baseUrl = '/pages';

  constructor(private router: Router,
    protected permissionsService: NgxPermissionsService) {
    const ROLE_CENTRAL = permissionsService.getPermissions().hasOwnProperty(environment.role_central);
    const ROLE_ADMIN = permissionsService.getPermissions().hasOwnProperty(environment.role_admin);
    if (ROLE_CENTRAL && ROLE_ADMIN) {
      this.menu = MENU_ITEMS_ALL;
      this.redirectUrl = '/incidents-activite/incidents-ouverts';
    } else if (ROLE_ADMIN) {
      this.menu = MENU_ITEMS_ADMIN;
      this.redirectUrl = '/incidents-activite/incidents-ouverts';
    } else if (ROLE_CENTRAL) {
      this.menu = MENU_ITEMS_CENTRAL;
      this.redirectUrl = '/maps/gmaps';
    }
  }

  ngOnInit(): void {
    if (this.baseUrl === this.router.url) {
      this.router.navigateByUrl(this.baseUrl + this.redirectUrl).then();
    }
  }
}
