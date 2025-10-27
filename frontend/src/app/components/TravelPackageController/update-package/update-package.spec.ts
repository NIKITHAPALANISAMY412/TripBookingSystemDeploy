import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatePackage } from './update-package';

describe('UpdatePackage', () => {
  let component: UpdatePackage;
  let fixture: ComponentFixture<UpdatePackage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpdatePackage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdatePackage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
