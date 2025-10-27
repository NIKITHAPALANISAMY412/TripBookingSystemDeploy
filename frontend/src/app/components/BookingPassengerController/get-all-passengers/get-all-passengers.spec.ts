import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllPassengers } from './get-all-passengers';

describe('GetAllPassengers', () => {
  let component: GetAllPassengers;
  let fixture: ComponentFixture<GetAllPassengers>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GetAllPassengers]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetAllPassengers);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
