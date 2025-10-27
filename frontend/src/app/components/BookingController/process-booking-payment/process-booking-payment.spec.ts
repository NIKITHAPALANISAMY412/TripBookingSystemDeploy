import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcessBookingPayment } from './process-booking-payment';

describe('ProcessBookingPayment', () => {
  let component: ProcessBookingPayment;
  let fixture: ComponentFixture<ProcessBookingPayment>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProcessBookingPayment]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProcessBookingPayment);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
