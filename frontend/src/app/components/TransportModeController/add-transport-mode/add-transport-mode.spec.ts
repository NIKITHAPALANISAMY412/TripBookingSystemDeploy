import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddTransportMode } from './add-transport-mode';

describe('AddTransportMode', () => {
  let component: AddTransportMode;
  let fixture: ComponentFixture<AddTransportMode>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddTransportMode]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddTransportMode);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
