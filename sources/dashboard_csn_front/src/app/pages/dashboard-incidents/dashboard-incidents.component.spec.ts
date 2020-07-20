import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { DashboardIncidentsComponent } from './dashboard-incidents.component';


describe('DashboardIncidentsComponent', () => {
  let component: DashboardIncidentsComponent;
  let fixture: ComponentFixture<DashboardIncidentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [DashboardIncidentsComponent],
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardIncidentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
