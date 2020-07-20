import { Component, OnDestroy, OnInit, AfterViewInit } from '@angular/core';
import { NbThemeService } from '@nebular/theme';
import { DashboardIncidentsService } from '../service/dashboard-incidents.service';
import { DashbIncidentOuvertFerme } from '../../../model/DashbIncidentOuvertFerme';

@Component({
  selector: 'ngx-chart-incidents-ouvert-ferme-nombre',
  template: `
  <div echarts [options]="options" class="echart echart-commembert"></div>

  `,
})
export class ChartIncidentsOuvertFermeNombreComponent implements AfterViewInit, OnDestroy, OnInit {
  incidents = [];
  options: any = {};
  themeSubscription: any;
  constructor(private theme: NbThemeService,
    protected service: DashboardIncidentsService) {
    this.onLoadIncidentsOuvertFermeNombre();
  }
  ngAfterViewInit() {
  }

  ngOnDestroy(): void {
    this.themeSubscription.unsubscribe();
  }

  ngOnInit() {
  }

  onLoadIncidentsOuvertFermeNombre() {
    this.service.getIncidentsOuvertFermeEnNombre()
      .subscribe((data: DashbIncidentOuvertFerme[]) => {
        if (data != null) {
          this.incidents = data;
          this.loadChart();
        }
      });
  }

  loadChart() {
    this.themeSubscription = this.theme.getJsTheme().subscribe(config => {

      // const colors = config.variables;
      const echarts: any = config.variables.echarts;

      this.options = {
        backgroundColor: echarts.bg,
        color: ['#84bb5c', '#d35d60'],
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b} : {c} ({d}%)',
        },
        legend: {
          orient: 'horizontal',
          center: 'top',
          data: this.incidents.forEach(() => name),
          textStyle: {
            color: echarts.textColor,
          },
        },
        series: [
          {
            name: '',
            type: 'pie',
            radius: '80%',
            center: ['50%', '50%'],
            data: this.incidents,
            itemStyle: {
              normal: {
                label: {
                  show: true, position: 'inner',
                  formatter: function (params) {
                    return params.value;
                  },
                },
                labelLine: {
                  show: false,
                },
              },
            },
            label: {
              normal: {
                textStyle: {
                  color: echarts.textColor,
                },
              },
            },
            labelLine: {
              normal: {
                lineStyle: {
                  color: echarts.axisLineColor,
                },
              },
            },
          },
        ],
      };
    });
  }
}
