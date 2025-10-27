import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetWalletByUserId } from './get-wallet-by-user-id';

describe('GetWalletByUserId', () => {
  let component: GetWalletByUserId;
  let fixture: ComponentFixture<GetWalletByUserId>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GetWalletByUserId]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetWalletByUserId);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
