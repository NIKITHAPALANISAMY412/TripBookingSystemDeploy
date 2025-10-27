import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Downloadreceipt } from './downloadreceipt';

describe('Downloadreceipt', () => {
  let component: Downloadreceipt;
  let fixture: ComponentFixture<Downloadreceipt>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Downloadreceipt]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Downloadreceipt);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
