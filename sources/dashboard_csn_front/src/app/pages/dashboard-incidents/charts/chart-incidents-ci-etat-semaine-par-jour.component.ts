import { Component, OnDestroy, OnInit, AfterViewInit } from '@angular/core';
import { NbThemeService } from '@nebular/theme';
import { DashboardIncidentsService } from '../service/dashboard-incidents.service';
import { DashIncidentCiEtatSemaineParJourParent } from '../../../model/DashIncidentCiEtatSemaineParJourParent';
import 'chartjs-plugin-labels';
@Component({
  selector: 'ngx-chart-incidents-ci-etat-semaine',
  template: `
  <chart type="bar" [data]="data" [options]="options"></chart>
  `,
})
export class ChartIncidentsCiEtatParSemaineComponent implements AfterViewInit, OnDestroy, OnInit {
  incidents = [];
  days = [];
  data: any;
  options: any;
  themeSubscription: any;

  constructor(private theme: NbThemeService,
    protected service: DashboardIncidentsService) {
    this.onLoadIncidentsCiEtatSemaineParJour();
  }

  ngAfterViewInit() {

  }
  ngOnDestroy(): void {
    this.themeSubscription.unsubscribe();
  }

  ngOnInit() {
  }

  onLoadIncidentsCiEtatSemaineParJour() {
    this.service.getIncidentsCiEtatSemaineParJour()
      .subscribe((data: DashIncidentCiEtatSemaineParJourParent[]) => {
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
              label: (d.name === 'ouvert' ? 'Ouvert' : 'Fermé'),
              backgroundColor: (d.name === 'ouvert' ? '#d35d60' : '#84bb5c'),
            });
          });
          this.loadChart();
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
            fontSize: 9,
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
