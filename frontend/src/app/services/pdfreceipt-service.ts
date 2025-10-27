import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class PDFReceiptService {
  private baseUrl = 'http://localhost:9090/api/receipts';

  constructor(private httpClient: HttpClient) {}

  // Download booking receipt as PDF
  downloadReceipt(bookingId: number): Observable<Blob> {
    return this.httpClient.get(`${this.baseUrl}/download/${bookingId}`, {
      responseType: 'blob',
    });
  }
}
