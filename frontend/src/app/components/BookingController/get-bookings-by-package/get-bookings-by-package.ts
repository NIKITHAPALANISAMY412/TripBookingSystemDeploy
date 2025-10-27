import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingDTO } from '../../../models/BookingDTO.model';
import { BookingService } from '../../../services/booking-service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-get-bookings-by-package',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './get-bookings-by-package.html',
  styleUrl: './get-bookings-by-package.css',
})
export class GetBookingsByPackage implements OnInit {
  packageId!: number;
  bookings: BookingDTO[] = [];

  constructor(private route: ActivatedRoute, private router: Router, private bookingService: BookingService) {}

  ngOnInit(): void {
    this.packageId = Number(this.route.snapshot.paramMap.get('packageId'));
    this.loadBookings();
  }

  loadBookings(): void {
    this.bookingService.getBookingsByPackageId(this.packageId).subscribe({
      next: (data) => (this.bookings = data),
      error: (err) => console.error(err),
    });
  }

  back(): void {
    this.router.navigate(['/get-all-bookings']);
  }

  viewBooking(id: number): void {
    this.router.navigate(['/view-detailed-booking', id]);
  }
}
