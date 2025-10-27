import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetPassenger } from './get-passenger';

describe('GetPassenger', () => {
  let component: GetPassenger;
  let fixture: ComponentFixture<GetPassenger>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GetPassenger]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetPassenger);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
