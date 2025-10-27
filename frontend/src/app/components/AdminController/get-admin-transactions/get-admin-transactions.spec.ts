import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAdminTransactions } from './get-admin-transactions';

describe('GetAdminTransactions', () => {
  let component: GetAdminTransactions;
  let fixture: ComponentFixture<GetAdminTransactions>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GetAdminTransactions]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetAdminTransactions);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
