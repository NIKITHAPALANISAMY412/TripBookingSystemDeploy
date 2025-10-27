import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPassenger } from './add-passenger';

describe('AddPassenger', () => {
  let component: AddPassenger;
  let fixture: ComponentFixture<AddPassenger>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddPassenger]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddPassenger);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
