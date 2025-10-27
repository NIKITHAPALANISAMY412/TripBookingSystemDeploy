import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAvailableTransportsByPackage } from './get-available-transports-by-package';

describe('GetAvailableTransportsByPackage', () => {
  let component: GetAvailableTransportsByPackage;
  let fixture: ComponentFixture<GetAvailableTransportsByPackage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GetAvailableTransportsByPackage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetAvailableTransportsByPackage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
