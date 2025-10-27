import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Getallbooks } from './getallbooks';

describe('Getallbooks', () => {
  let component: Getallbooks;
  let fixture: ComponentFixture<Getallbooks>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Getallbooks]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Getallbooks);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
