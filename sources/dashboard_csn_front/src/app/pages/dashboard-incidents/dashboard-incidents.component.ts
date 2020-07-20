import { Component, OnInit } from '@angular/core';
import { DashboardIncidentsService } from './service/dashboard-incidents.service';
import { Cumul } from '../../model/Cumul';

@Component({
  selector: 'ngx-dashboard-incidents',
  styleUrls: ['./dashboard-incidents.component.scss'],
  templateUrl: './dashboard-incidents.component.html',
  styles: [`
    nb-card {
      transform: translate3d(0, 0, 0);
    }
  `],
})
export class DashboardIncidentsComponent implements OnInit {
  day: any = '';
  hour: any = '';

  constructor(protected service: DashboardIncidentsService) { }

  ngOnInit() {
    this.onLoadCumulDetails();
  }

  onLoadCumulDetails() {

    this.service.getCumulDetails()
      .subscribe((data: Cumul) => {
        if (data != null) {
          this.day = data.day;
          this.hour = data.hour;
        }
      });
  }
}
