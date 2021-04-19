import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoggedUserHeaderComponent } from './logged-user-header.component';

describe('LoggedUserHeaderComponent', () => {
  let component: LoggedUserHeaderComponent;
  let fixture: ComponentFixture<LoggedUserHeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoggedUserHeaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoggedUserHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
