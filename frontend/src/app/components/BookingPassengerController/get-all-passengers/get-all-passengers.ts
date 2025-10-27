import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { BookingPassengerDTO } from '../../../models/BookingPassengerDTO.model';
import { BookingPassengerService } from '../../../services/booking-passenger-service';

@Component({
  selector: 'get-all-passengers',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './get-all-passengers.html',
  styleUrl: './get-all-passengers.css',
})
export class GetAllPassengers implements OnInit {
  passengers: BookingPassengerDTO[] = [];

  constructor(private passengerService: BookingPassengerService, private router: Router) {}

  ngOnInit(): void {
    this.loadPassengers();
  }

  loadPassengers(): void {
    this.passengerService.getAllPassengers().subscribe({
      next: (data) => (this.passengers = data),
      error: (err) => console.error('Error loading passengers:', err),
    });
  }

  viewPassenger(id: number): void {
    this.router.navigate(['/get-passenger', id]);
  }

  backToAdmin(): void {
    this.router.navigate(['/admindashboard']);
  }
}
