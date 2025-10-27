import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { PDFReceiptService } from '../../../services/pdfreceipt-service';


@Component({
  selector: 'app-downloadreceipt',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './downloadreceipt.html',
  styleUrl: './downloadreceipt.css',
})
export class Downloadreceipt {
  bookingId!: number;

  constructor(private pdfService: PDFReceiptService, private router: Router) {}

  download(): void {
    if (!this.bookingId) {
      alert('Please enter a Booking ID');
      return;
    }

    this.pdfService.downloadReceipt(this.bookingId).subscribe({
      next: (blob) => {
        const url = window.URL.createObjectURL(blob);
        const a = document.createElement('a');
        a.href = url;
        a.download = `BookingReceipt_${this.bookingId}.pdf`;
        a.click();
        window.URL.revokeObjectURL(url);
      },
      error: (err) => console.error('Error downloading receipt:', err),
    });
  }

  backToAdmin(): void {
    this.router.navigate(['/admindashboard']);
  }
}
