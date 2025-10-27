import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllTransactions } from './get-all-transactions';

describe('GetAllTransactions', () => {
  let component: GetAllTransactions;
  let fixture: ComponentFixture<GetAllTransactions>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GetAllTransactions]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetAllTransactions);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
