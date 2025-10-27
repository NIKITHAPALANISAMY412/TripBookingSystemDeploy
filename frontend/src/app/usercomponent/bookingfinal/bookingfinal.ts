import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookingDTO } from '../../models/BookingDTO.model';
import { TravelPackageDTO } from '../../models/TravelPackageDTO.model';
import { TravelPackageService } from '../../services/travel-package-service';
import { BookingService } from '../../services/booking-service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../services/auth-service';

@Component({
  selector: 'app-bookingfinal',
  templateUrl: './bookingfinal.html',
  styleUrls: ['./bookingfinal.css'],
  imports: [FormsModule, CommonModule]
})
export class Bookingfinal implements OnInit {

  travelPackage?: TravelPackageDTO;
  booking: BookingDTO = {
    userId: 0,
    packageId: 0,
    bookingTotalAmount: 0
  };
  isPaymentProcessing: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private travelService: TravelPackageService,
    private bookingService: BookingService,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    const packageId = Number(this.route.snapshot.paramMap.get('id'));

    this.travelService.getPackageById(packageId).subscribe(pkg => {
      this.travelPackage = pkg;

      // Build booking object without transport
      this.booking = {
        userId: this.authService.retrieveUserId(),
        packageId: pkg.id!,
        bookingTotalAmount: pkg.packageBasePrice!,
        bookingStatus: 'PENDING'
      };
    });
  }

  confirmBooking() {
    if (!this.travelPackage) return;

    this.bookingService.addBooking(this.booking).subscribe({
      next: bookingRes => {
        alert('Booking confirmed! 🎉');
        this.processPayment();
      },
      error: err => console.error('Booking failed', err)
    });
  }

  private processPayment() {
    if (!this.travelPackage) return;

    this.isPaymentProcessing = true;

    const userId = this.authService.retrieveUserId()!;
    const packageId = this.travelPackage.id!;
    const totalAmount = this.travelPackage.packageBasePrice!;

    this.bookingService.processBookingPayment(userId, packageId, null, totalAmount)
      .subscribe({
        next: res => {
          this.isPaymentProcessing = false;
          alert('Payment successful! 💳 Your trip is booked.');
        },
        error: err => {
          this.isPaymentProcessing = false;
          console.error('Payment failed', err);
        }
      });
  }
}
