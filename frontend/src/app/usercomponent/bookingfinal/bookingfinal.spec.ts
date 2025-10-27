import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Bookingfinal } from './bookingfinal';

describe('Bookingfinal', () => {
  let component: Bookingfinal;
  let fixture: ComponentFixture<Bookingfinal>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Bookingfinal]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Bookingfinal);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
