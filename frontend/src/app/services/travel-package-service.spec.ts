import { TestBed } from '@angular/core/testing';

import { TravelPackageService } from './travel-package-service';

describe('TravelPackageService', () => {
  let service: TravelPackageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TravelPackageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
