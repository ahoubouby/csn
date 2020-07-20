import { Component, OnDestroy, OnInit, AfterViewInit } from '@angular/core';
import { NbThemeService } from '@nebular/theme';
import { DashboardIncidentsService } from '../service/dashboard-incidents.service';
import 'chartjs-plugin-labels';
import { DashIncidentNameParent } from '../../../model/DashIncidentNameParent';
@Component({
  selector: 'ngx-chart-incidents-ci-ferme-direction',
  template: `
  <chart type="bar" [data]="data" [options]="options"></chart>
  `,
})
export class ChartIncidentsCiFermeDirectionComponent implements AfterViewInit, OnDestroy, OnInit {
  incidents = [];
  directions = [];
  data: any;
  options: any;
  themeSubscription: any;
  colors = new Set();
  customColor = [];

  constructor(private theme: NbThemeService,
    protected service: DashboardIncidentsService) {
    this.onLoadIncidentsCiFermeParDirection();
  }

  ngAfterViewInit() {

  }
  ngOnDestroy(): void {
    this.themeSubscription.unsubscribe();
  }

  ngOnInit() {
  }

  onLoadIncidentsCiFermeParDirection() {
    this.service.getIncidentsCiFermeParDirection()
      .subscribe((data: DashIncidentNameParent[]) => {
        if (data != null) {
          data[0].value.forEach(element => {
            const name = element.name === 'DIRECTION EXPLOITATION' ? 'D.EXP' : element.name;
            this.directions.push(name);
          });
          data.forEach(d => {
            const values = [];
            d.value.forEach(element => {
              values.push(element.value);
            });
            this.incidents.push({
              data: values,
              label: d.day,
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
    entries.forEach((element, index) => {
      switch (index) {
        case 0:
          element.backgroundColor = '#7394cb';
          break;
        case 1:
          element.backgroundColor = '#e1974d';
          break;
        case 2:
          element.backgroundColor = '#84bb5c';
          break;
        case 3:
          element.backgroundColor = '#d35d60';
          break;
        case 4:
          element.backgroundColor = '#818787';
          break;
        case 5:
          element.backgroundColor = '#9066a7';
          break;
        case 6:
          element.backgroundColor = '#ad6a58';
          break;
      }
    });
    this.colors.forEach((value: string) => {
      this.customColor.push(value);
    });
  }

  loadChart() {
    this.themeSubscription = this.theme.getJsTheme().subscribe(config => {
      const chartjs: any = config.variables.chartjs;

      this.data = {
        labels: this.directions,
        datasets: this.incidents,
      };

      this.options = {
        maintainAspectRatio: true,
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
