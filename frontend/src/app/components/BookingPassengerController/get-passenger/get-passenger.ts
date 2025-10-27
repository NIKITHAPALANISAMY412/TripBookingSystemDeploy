import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { BookingPassengerDTO } from '../../../models/BookingPassengerDTO.model';
import { BookingPassengerService } from '../../../services/booking-passenger-service';

@Component({
  selector: 'get-passenger',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './get-passenger.html',
  styleUrl: './get-passenger.css',
})
export class GetPassenger implements OnInit {
  passengerId!: number;
  passenger: BookingPassengerDTO = { bookingId: 0 };

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private passengerService: BookingPassengerService
  ) {}

  ngOnInit(): void {
    this.passengerId = Number(this.route.snapshot.paramMap.get('id'));
    this.loadPassenger();
  }

  loadPassenger(): void {
    this.passengerService.getPassengerById(this.passengerId).subscribe({
      next: (data) => (this.passenger = data),
      error: (err) => console.error('Error loading passenger:', err),
    });
  }

  backToList(): void {
    this.router.navigate(['/get-all-passengers']);
  }
}
