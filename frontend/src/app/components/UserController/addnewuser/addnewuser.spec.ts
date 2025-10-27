import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Addnewuser } from './addnewuser';

describe('Addnewuser', () => {
  let component: Addnewuser;
  let fixture: ComponentFixture<Addnewuser>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Addnewuser]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Addnewuser);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
