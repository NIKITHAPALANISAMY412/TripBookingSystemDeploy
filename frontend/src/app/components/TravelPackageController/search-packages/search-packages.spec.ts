import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchPackages } from './search-packages';

describe('SearchPackages', () => {
  let component: SearchPackages;
  let fixture: ComponentFixture<SearchPackages>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SearchPackages]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchPackages);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
