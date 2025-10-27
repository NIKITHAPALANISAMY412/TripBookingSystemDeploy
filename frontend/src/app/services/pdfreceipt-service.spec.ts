import { TestBed } from '@angular/core/testing';

import { PDFReceiptService } from './pdfreceipt-service';

describe('PDFReceiptService', () => {
  let service: PDFReceiptService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PDFReceiptService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
