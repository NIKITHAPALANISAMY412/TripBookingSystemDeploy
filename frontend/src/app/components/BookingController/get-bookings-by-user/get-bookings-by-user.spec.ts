import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetBookingsByUser } from './get-bookings-by-user';

describe('GetBookingsByUser', () => {
  let component: GetBookingsByUser;
  let fixture: ComponentFixture<GetBookingsByUser>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GetBookingsByUser]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetBookingsByUser);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
