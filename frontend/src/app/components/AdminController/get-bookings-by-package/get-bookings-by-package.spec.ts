import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetBookingsByPackage } from './get-bookings-by-package';

describe('GetBookingsByPackage', () => {
  let component: GetBookingsByPackage;
  let fixture: ComponentFixture<GetBookingsByPackage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GetBookingsByPackage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetBookingsByPackage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
