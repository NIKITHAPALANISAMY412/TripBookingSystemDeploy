import { Component, OnInit } from '@angular/core';
import { BookingService } from '../../services/booking-service';
import { AuthService } from '../../services/auth-service';
import { BookingDTO } from '../../models/BookingDTO.model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-user-bookings-component',
  imports: [CommonModule, FormsModule],
  templateUrl: './user-bookings-component.html',
  styleUrls: ['./user-bookings-component.css'],
})
export class UserBookingsComponent implements OnInit {

  bookings: BookingDTO[] = [];
  isLoading = true;
  errorMessage = '';

  constructor(
    private bookingService: BookingService,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.loadBookings();
  }

  loadBookings(): void {
    const userId = this.authService.retrieveUserId();
    if (!userId) {
      this.errorMessage = 'User not logged in.';
      this.isLoading = false;
      return;
    }

    this.bookingService.getBookingsByUserId(userId).subscribe({
      next: (res) => {
        this.bookings = res;
        this.isLoading = false;
      },
      error: (err) => {
        console.error(err);
        this.errorMessage = 'Failed to fetch bookings.';
        this.isLoading = false;
      }
    });
  }

  cancelBooking(bookingId: number): void {
    if (!confirm('Are you sure you want to cancel this booking?')) return;

    this.bookingService.cancelBooking(bookingId).subscribe({
      next: (res) => {
        alert('Booking cancelled successfully!');
        // Update booking status locally
        const index = this.bookings.findIndex(b => b.id === bookingId);
        if (index !== -1) this.bookings[index].bookingStatus = 'CANCELLED';
      },
      error: (err) => {
        console.error(err);
        alert('Failed to cancel booking.');
      }
    });
  }
}
