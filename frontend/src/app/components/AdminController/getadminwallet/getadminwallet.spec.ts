import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Getadminwallet } from './getadminwallet';

describe('Getadminwallet', () => {
  let component: Getadminwallet;
  let fixture: ComponentFixture<Getadminwallet>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Getadminwallet]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Getadminwallet);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
