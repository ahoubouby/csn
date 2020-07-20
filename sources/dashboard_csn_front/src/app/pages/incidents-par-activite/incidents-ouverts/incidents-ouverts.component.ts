import { OnInit, Component, Input } from '@angular/core';
import { LocalDataSource } from 'ng2-smart-table';
import { IncidentsActiviteService } from '../service/incidents.activite.service';
import { NbDialogService } from '@nebular/theme';
import { IncidentsOuvertsDialogComponent } from '../incidents-ouverts-dialog/incidents-ouverts-dialog.component';
import { IncidentOuverActivite } from '../../../model/IncidentOuverActivite';
import { message } from '../../../services/message';
@Component({
  template: `
    <span class='btn btn-info btn-icon' (click)='addComment()'><i class='icon ion-chatbox'></i></span>
  `,
  styles: [`
    .btn-info:hover {
      background-color: #FA2406 !important;
      border-color: #FA2406 !important;
    }
  `],

})
export class IncOuvCommentsButtonComponent implements OnInit {
  incidentToComment: IncidentOuverActivite;
  @Input() value;
  constructor(private dialogService: NbDialogService) {
  }

  ngOnInit() {
    this.incidentToComment = this.value;
  }
  addComment() {
    this.dialogService.open(IncidentsOuvertsDialogComponent, {
      context: {
        incident: this.incidentToComment,
      },
      hasScroll: true,
    });
  }
}
@Component({
  selector: 'ngx-incidents-ouverts',
  styleUrls: ['./incidents-ouverts.component.scss'],
  templateUrl: './incidents-ouverts.component.html',
  styles: [`
    nb-card {
      transform: translate3d(0, 0, 0);
    }
  `],
})
export class IncidentsOuvertsActiviteComponent implements OnInit {
  public source: LocalDataSource = new LocalDataSource();
  settings: Object;
  incidents = [];
  totalData: number;
  msgData: boolean = false;
  msgNoData: string = '';
  loadTableSettings() {
    return {
      noDataMessage: message.rechercheVide,
      actions: false,
      pager: {
        display: true,
        perPage: 8,
      },
      mode: 'external',
      columns: {
        jour: {
          title: 'Date',
          type: 'string',
        },
        activite: {
          title: 'Activité',
          type: 'string',
        },
        nombre: {
          title: 'Nombre',
          type: 'string',
        },
        commentaire: {
          title: 'Commentaire',
          type: 'string',
        },
        incidentToComment: {
          title: 'Action',
          type: 'custom',
          filter: false,
          renderComponent: IncOuvCommentsButtonComponent,
        },
      },
    };
  }

  constructor(private service: IncidentsActiviteService) { }

  ngOnInit(): void {
    this.settings = this.loadTableSettings();
    this.onLoad();
    this.service.getValue().subscribe(
      (data) => {
        if (data) {
          this.onLoad();
        }
      });

  }
  onLoad() {
    this.incidents = [];
    this.service.incidentsActiviteOuvertAdmin()
      .subscribe((data: any) => {
        if (data) {
          data.forEach(d => {
            this.incidents.push({
              jour: d.jour,
              activite: d.activite,
              nombre: d.nombre,
              commentaire: d.commentaire,
              incidentToComment: d,
            });
          });
          this.source.load(this.incidents);
          this.totalData = this.incidents.length;
          this.service.sendValue(false);
        } else {
          this.msgData = true;
          this.msgNoData = message.rechercheVide;
        }

      }, err => {
        this.msgData = true;
        this.msgNoData = err.error.message;
      });
  }
}
