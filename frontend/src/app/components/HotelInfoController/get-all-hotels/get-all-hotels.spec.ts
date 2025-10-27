import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllHotels } from './get-all-hotels';

describe('GetAllHotels', () => {
  let component: GetAllHotels;
  let fixture: ComponentFixture<GetAllHotels>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GetAllHotels]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetAllHotels);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
