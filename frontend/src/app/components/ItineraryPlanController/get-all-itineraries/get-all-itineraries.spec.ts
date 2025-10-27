import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllItineraries } from './get-all-itineraries';

describe('GetAllItineraries', () => {
  let component: GetAllItineraries;
  let fixture: ComponentFixture<GetAllItineraries>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GetAllItineraries]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetAllItineraries);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
