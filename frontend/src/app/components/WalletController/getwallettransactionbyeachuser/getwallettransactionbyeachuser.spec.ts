import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Getwallettransactionbyeachuser } from './getwallettransactionbyeachuser';

describe('Getwallettransactionbyeachuser', () => {
  let component: Getwallettransactionbyeachuser;
  let fixture: ComponentFixture<Getwallettransactionbyeachuser>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Getwallettransactionbyeachuser]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Getwallettransactionbyeachuser);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
