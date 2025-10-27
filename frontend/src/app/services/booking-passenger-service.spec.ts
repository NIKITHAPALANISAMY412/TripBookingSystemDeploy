import { TestBed } from '@angular/core/testing';

import { BookingPassengerService } from './booking-passenger-service';

describe('BookingPassengerService', () => {
  let service: BookingPassengerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BookingPassengerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
