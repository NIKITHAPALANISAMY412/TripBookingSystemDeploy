import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateTransportMode } from './update-transport-mode';

describe('UpdateTransportMode', () => {
  let component: UpdateTransportMode;
  let fixture: ComponentFixture<UpdateTransportMode>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpdateTransportMode]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateTransportMode);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
