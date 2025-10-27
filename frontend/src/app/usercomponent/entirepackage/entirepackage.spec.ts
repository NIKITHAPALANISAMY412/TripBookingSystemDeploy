import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Entirepackage } from './entirepackage';

describe('Entirepackage', () => {
  let component: Entirepackage;
  let fixture: ComponentFixture<Entirepackage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Entirepackage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Entirepackage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
