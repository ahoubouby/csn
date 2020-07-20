import { Component, Input } from '@angular/core';

@Component({
  selector: 'ngx-slide-out',
  styleUrls: ['./slide-out.component.scss'],
  templateUrl: './slide-out.component.html',
})
export class SlideOutComponent {

  private _showFilter: boolean = false;

  get showFilter(): boolean {
    return this._showFilter;
  }

  @Input()
  set showFilter(val: boolean) {
    this._showFilter = val;
  }

  toggleFilters() {
    this._showFilter = !this._showFilter;
  }
}
