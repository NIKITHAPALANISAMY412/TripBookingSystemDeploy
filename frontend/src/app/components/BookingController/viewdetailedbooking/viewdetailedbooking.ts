import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingDTO } from '../../../models/BookingDTO.model';
import { BookingService } from '../../../services/booking-service';

@Component({
  selector: 'viewdetailedbooking',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './viewdetailedbooking.html',
  styleUrls: ['./viewdetailedbooking.css'],
})
export class Viewdetailedbooking implements OnInit {
  bookingId!: number;
  booking!: BookingDTO;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private bookingService: BookingService
  ) {}

  ngOnInit(): void {
    this.bookingId = Number(this.route.snapshot.paramMap.get('id'));
    this.loadBooking();
  }

  loadBooking(): void {
    this.bookingService.getBookingById(this.bookingId).subscribe({
      next: (data) => (this.booking = data),
      error: (err) => console.error('Error loading booking details:', err),
    });
  }

  back(): void {
    this.router.navigate(['/get-all-bookings']);
  }
}
