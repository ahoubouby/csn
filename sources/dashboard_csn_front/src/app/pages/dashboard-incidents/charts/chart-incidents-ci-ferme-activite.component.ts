import { Component, OnDestroy, OnInit, AfterViewInit } from '@angular/core';
import { NbThemeService } from '@nebular/theme';
import { DashboardIncidentsService } from '../service/dashboard-incidents.service';
import { DashIncidentDateParent } from '../../../model/DashIncidentDateParent';
import 'chartjs-plugin-labels';
@Component({
  selector: 'ngx-chart-incidents-ci-ferme-activite-semaine',
  template: `
 <chart type="line" [data]="data" [options]="options"></chart>
  `,
})
export class ChartIncidentsCiFermeActiviteComponent implements AfterViewInit, OnDestroy, OnInit {
  data: {};
  incidents = [];
  days = [];
  options: any = {};
  themeSubscription: any;
  colors = new Set();
  customColor = [];

  constructor(private theme: NbThemeService,
    protected service: DashboardIncidentsService) {
    this.onLoadIncidentsCiFermeActiviteSemaine();
  }

  ngAfterViewInit() {

  }

  ngOnDestroy(): void {
    this.themeSubscription.unsubscribe();
  }

  ngOnInit(): void {

  }
  onLoadIncidentsCiFermeActiviteSemaine() {
    this.service.getIncidentsCiFermeActiviteSemaine()
      .subscribe((data: DashIncidentDateParent[]) => {
        if (data != null) {
          data[0].value.forEach(element => {
            this.days.push(element.day);
          });
          data.forEach(d => {
            const values = [];
            d.value.forEach(element => {
              values.push(element.value);
            });
            this.incidents.push({
              label: d.name,
              data: values,
              fill: false,
              borderDash: [0, 0],
              pointRadius: 4,
              pointHoverRadius: 6,
            });
          });
          this.getRandomColor(this.incidents);
          this.loadChart();
        }
      }, err => {
      });
  }
  getRandomColor(entries: any) {
    /*  #7394cb
        #e1974d
        #84bb5c
        #d35d60
        #818787
        #9066a7
        #ad6a58
        #ccc374 */
    entries.forEach((element) => {
      if (element.label === 'Radio') {
        element.borderColor = '#7394cb';
        element.backgroundColor = '#7394cb';
      }
      if (element.label === 'PFS') {
        element.borderColor = '#e1974d';
        element.backgroundColor = '#e1974d';
      }
      if (element.label === 'Transmission') {
        element.borderColor = '#84bb5c';
        element.backgroundColor = '#84bb5c';
      }
      if (element.label === 'Commutation') {
        element.borderColor = '#ccc374';
        element.backgroundColor = '#ccc374';
      }
    });
  }

  loadChart() {
    this.themeSubscription = this.theme.getJsTheme().subscribe(config => {

      // const colors: any = config.variables;
      const chartjs: any = config.variables.chartjs;

      this.data = {
        labels: this.days,
        datasets: this.incidents,
      };

      this.options = {
        responsive: true,
        maintainAspectRatio: true, // customized
        legend: {
          position: 'top', // customized
          labels: {
            fontColor: chartjs.textColor,
          },
        },
        /*         tooltips: {  // customized
                  mode: 'index', // all
                  intersect: true,
                },
                hover: { // customized
                  mode: 'index', // all
                  intersect: true,
                }, */
        scales: {
          xAxes: [
            {
              display: true,
              scaleLabel: {
                display: true,
                labelString: '', // customized
              },
              gridLines: {
                display: true,
                color: chartjs.axisLineColor,
              },
              ticks: {
                fontColor: chartjs.textColor,
              },
            },
          ],
          yAxes: [
            {
              display: true,
              scaleLabel: {
                display: true,
                labelString: '', // customized
              },
              gridLines: {
                display: true,
                color: chartjs.axisLineColor,
              },
              ticks: {
                fontColor: chartjs.textColor,
              },
            },
          ],
        },
      };
    });
  }
}
