import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllWallets } from './get-all-wallets';

describe('GetAllWallets', () => {
  let component: GetAllWallets;
  let fixture: ComponentFixture<GetAllWallets>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GetAllWallets]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetAllWallets);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
