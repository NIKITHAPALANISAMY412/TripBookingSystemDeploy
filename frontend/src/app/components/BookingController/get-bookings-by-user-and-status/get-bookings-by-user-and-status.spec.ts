import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetBookingsByUserAndStatus } from './get-bookings-by-user-and-status';

describe('GetBookingsByUserAndStatus', () => {
  let component: GetBookingsByUserAndStatus;
  let fixture: ComponentFixture<GetBookingsByUserAndStatus>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GetBookingsByUserAndStatus]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetBookingsByUserAndStatus);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
