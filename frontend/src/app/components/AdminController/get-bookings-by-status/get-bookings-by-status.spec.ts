import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetBookingsByStatus } from './get-bookings-by-status';

describe('GetBookingsByStatus', () => {
  let component: GetBookingsByStatus;
  let fixture: ComponentFixture<GetBookingsByStatus>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GetBookingsByStatus]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetBookingsByStatus);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
