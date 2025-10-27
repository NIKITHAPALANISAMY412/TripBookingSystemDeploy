import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllTransportModes } from './get-all-transport-modes';

describe('GetAllTransportModes', () => {
  let component: GetAllTransportModes;
  let fixture: ComponentFixture<GetAllTransportModes>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GetAllTransportModes]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetAllTransportModes);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
