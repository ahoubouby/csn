import { Component, Input, OnInit } from '@angular/core';
import { NbDialogRef, NbToastrService, NbComponentStatus, NbGlobalPhysicalPosition } from '@nebular/theme';
import { FormBuilder } from '@angular/forms';
import { IncidentOuverActivite } from '../../../model/IncidentOuverActivite';
import { IncidentsActiviteService } from '../service/incidents.activite.service';
import { ConfirmationService } from '@jaspero/ng-confirmations';
import { message } from '../../../services/message';

@Component({
  selector: 'ngx-incidents-ouverts-dialog',
  templateUrl: 'incidents-ouverts-dialog.component.html',
  styleUrls: ['incidents-ouverts-dialog.component.scss'],
})
export class IncidentsOuvertsDialogComponent implements OnInit {

  @Input() incident: IncidentOuverActivite;

  submitted = false;
  incidentCommentForm = this.fb.group({
    newComment: '',
  });
  constructor(protected ref: NbDialogRef<IncidentsOuvertsDialogComponent>,
    public fb: FormBuilder,
    private toastrService: NbToastrService,
    private confirmService: ConfirmationService,
    private service: IncidentsActiviteService) { }

  get f() { return this.incidentCommentForm.controls; }

  ngOnInit(): void {
  }

  public optionsConfirm = {
    overlay: true,
    overlayClickToClose: true,
    showCloseButton: true,
    confirmText: 'Oui',
    declineText: 'Non',
  };

  private showToast(type: NbComponentStatus, title: string, body: string, duration: number) {
    const config = {
      status: type,
      destroyByClick: true,
      duration: duration,
      hasIcon: true,
      position: NbGlobalPhysicalPosition.TOP_RIGHT,
      preventDuplicates: false,
    };
    const titleContent = title ? `${title}` : '';

    this.toastrService.show(
      body,
      `${titleContent}`,
      config);
  }
  dismiss() {
    this.ref.close();
  }
  saveIncident() {
    this.submitted = true;
    if (this.incidentCommentForm.invalid) {
      this.showToast('danger', 'Attention !', 'Prière de remplir tous les champs obligatoires !', 5000);
      return;
    }
    const oldComment = this.incident.commentaire;
    const newComment = this.incidentCommentForm.get('newComment').value;

    if (newComment === '') {
      this.ref.close(this.incident);
      return;
    } else {
      this.confirmService.create('màj commentaire ',
        'Voulez vous vraiment ajouter ce nouveau commentaire à l\'incident ayant comme activité: '
        + this.incident.activite
        + ' et nombre: '
        + this.incident.nombre
        + ' ?')
        .subscribe(resp => {
          if (resp.resolved === true) {
            this.incident.commentaire = newComment;
            this.service.updateIncident(this.incident)
              .subscribe((data: IncidentOuverActivite) => {
                if (data != null) {
                  this.showToast('success',
                    'Ajout nouveau commentaire',
                    message.msgSucces, 3000);
                  this.service.sendValue(true);
                } else {
                  this.incident.commentaire = oldComment;
                  this.showToast('danger',
                    'Ajout nouveau commentaire',
                    message.msgError, 3000);
                }
              });
          }
          this.ref.close(this.incident);
        });

    }

  }
}
