import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { BookingDTO } from '../../../models/BookingDTO.model';
import { BookingService } from '../../../services/booking-service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-get-all-bookings',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './get-all-bookings.html',
  styleUrl: './get-all-bookings.css',
})
export class GetAllBookings implements OnInit {
  bookings: BookingDTO[] = [];
  packageId!: number; // <-- add this line

  constructor(private bookingService: BookingService, private router: Router) {}

  ngOnInit(): void {
    this.loadBookings();
  }

  loadBookings(): void {
    this.bookingService.getAllBookings().subscribe({
      next: (data) => (this.bookings = data),
      error: (err) => console.error('Error loading bookings:', err),
    });
  }

  viewBooking(id: number): void {
    this.router.navigate(['/view-detailed-booking', id]);
  }

  backToAdmin(): void {
    this.router.navigate(['/admindashboard']);
  }

  viewByPackage(): void {
    if (this.packageId) {
      this.router.navigate(['/get-bookings-by-package', this.packageId]);
    }
  }
}
