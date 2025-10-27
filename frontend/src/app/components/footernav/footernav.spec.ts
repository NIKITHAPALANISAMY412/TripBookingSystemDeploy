import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Footernav } from './footernav';

describe('Footernav', () => {
  let component: Footernav;
  let fixture: ComponentFixture<Footernav>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Footernav]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Footernav);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
