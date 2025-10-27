import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HotelInfoDTO } from '../../../models/HotelInfoDTO.model';
import { HotelInfoService } from '../../../services/hotel-info-service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'get-all-hotels',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './get-all-hotels.html',
  styleUrls: ['./get-all-hotels.css'],
})
export class GetAllHotels implements OnInit {
  hotels: HotelInfoDTO[] = [];

  constructor(
    private hotelService: HotelInfoService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadHotels();
  }

  // Load all hotels from backend
  loadHotels(): void {
    this.hotelService.getAllHotels().subscribe({
      next: (response) => (this.hotels = response),
      error: (err) => console.error(err),
    });
  }

  // Navigate to Add Hotel page
  addHotel(): void {
    this.router.navigate(['get-all-hotels/add-hotel']);
  }

  // Navigate to Update Hotel page with hotel id
  editHotel(id: number): void {
    this.router.navigate(['get-all-hotels/update-hotel', id]);
  }

  // Delete hotel
  deleteHotel(id: number): void {
    if (confirm('Are you sure you want to delete this hotel?')) {
      this.hotelService.deleteHotel(id).subscribe({
        next: () => this.loadHotels(),
        error: (err) => console.error(err),
      });
    }
  }

  // Navigate back to Admin Dashboard
  goBack(): void {
    this.router.navigate(['/admindashboard']);
  }
}
