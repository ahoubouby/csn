import { Component, OnDestroy, OnInit, AfterViewInit } from '@angular/core';
import { NbThemeService } from '@nebular/theme';
import { DashboardIncidentsService } from '../service/dashboard-incidents.service';
import { RandomColor } from 'angular-randomcolor';
import { DashIncidentDateParent } from '../../../model/DashIncidentDateParent';
import 'chartjs-plugin-labels';
@Component({
  selector: 'ngx-chart-incidents-ci-ferme-division-semaine',
  template: `
  <chart type="bar" [data]="data" [options]="options"></chart>
  `,
})
export class ChartIncidentsCiFermeDivisionComponent implements AfterViewInit, OnDestroy, OnInit {
  incidents = [];
  days = [];
  data: any;
  options: any;
  themeSubscription: any;
  colors = new Set();
  customColor = [];

  constructor(private theme: NbThemeService,
    protected service: DashboardIncidentsService) {
    this.onLoadIncidentsCiFermeDivisionSemaine();
  }

  ngAfterViewInit() {

  }
  ngOnDestroy(): void {
    this.themeSubscription.unsubscribe();
  }

  ngOnInit() {
  }

  onLoadIncidentsCiFermeDivisionSemaine() {
    this.service.getIncidentsCiFermeDivisionSemaine()
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
              data: values,
              label: d.name,
              backgroundColor: '',
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
      const newColor: string = RandomColor.generateColor();
      // element.backgroundColor = newColor;
      this.colors.add(newColor);
      if (element.label === 'DRA') {
        element.backgroundColor = '#7394cb';
      }
      if (element.label === 'DRC') {
        element.backgroundColor = '#e1974d';
      }
      if (element.label === 'DRF') {
        element.backgroundColor = '#84bb5c';
      }
      if (element.label === 'DRM') {
        element.backgroundColor = '#d35d60';
      }
      if (element.label === 'DRO') {
        element.backgroundColor = '#818787';
      }
      if (element.label === 'DRR') {
        element.backgroundColor = '#9066a7';
      }
      if (element.label === 'DRS') {
        element.backgroundColor = ' #ad6a58';
      }
      if (element.label === 'DIRECTION EXPLOITATION') {
        element.backgroundColor = '#ccc374';
      }
    });
    this.colors.forEach((value: string) => {
      this.customColor.push(value);
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
        maintainAspectRatio: true, // customized
        responsive: true,
        legend: {
          labels: {
            fontColor: chartjs.textColor,
          },
        },
        scales: {
          xAxes: [
            {
              gridLines: {
                display: true, // customized
                color: chartjs.axisLineColor,
              },
              ticks: {
                fontColor: chartjs.textColor,
              },
            },
          ],
          yAxes: [
            {
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
        plugins: {
          labels: {
            render: 'value',
            fontSize: 8,
            showZero: false,
            fontColor: 'red',
            textMargin: 0,
            outsidePadding: 4,
            fontStyle: 'bold',
          },
        },
      };
    });
  }

}
