import { TestBed } from '@angular/core/testing';

import { ItineraryPlanService } from './itinerary-plan-service';

describe('ItineraryPlanService', () => {
  let service: ItineraryPlanService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ItineraryPlanService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
