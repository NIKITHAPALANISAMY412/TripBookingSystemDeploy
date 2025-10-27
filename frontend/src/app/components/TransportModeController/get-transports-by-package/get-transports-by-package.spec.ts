import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetTransportsByPackage } from './get-transports-by-package';

describe('GetTransportsByPackage', () => {
  let component: GetTransportsByPackage;
  let fixture: ComponentFixture<GetTransportsByPackage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GetTransportsByPackage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetTransportsByPackage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
