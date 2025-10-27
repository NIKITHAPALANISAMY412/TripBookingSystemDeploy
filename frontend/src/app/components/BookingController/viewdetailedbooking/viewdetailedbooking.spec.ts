import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Viewdetailedbooking } from './viewdetailedbooking';

describe('Viewdetailedbooking', () => {
  let component: Viewdetailedbooking;
  let fixture: ComponentFixture<Viewdetailedbooking>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Viewdetailedbooking]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Viewdetailedbooking);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
