import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllActivePackages } from './get-all-active-packages';

describe('GetAllActivePackages', () => {
  let component: GetAllActivePackages;
  let fixture: ComponentFixture<GetAllActivePackages>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GetAllActivePackages]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetAllActivePackages);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
