import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HotelInfoService } from '../../../services/hotel-info-service';
import { HotelInfoDTO } from '../../../models/HotelInfoDTO.model';

@Component({
  selector: 'add-hotel',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './add-hotel.html',
  styleUrls: ['./add-hotel.css'],
})
export class AddHotelComponent implements OnInit {
  hotelForm!: FormGroup;
  submitted = false;

  constructor(
    private fb: FormBuilder,
    private hotelService: HotelInfoService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.hotelForm = this.fb.group({
      packageId: ['', Validators.required],
      hotelName: ['', Validators.required],
      hotelLocation: ['', Validators.required],
      hotelRating: [null, [Validators.required, Validators.min(1), Validators.max(5)]],
      hotelPricePerNight: [null, [Validators.required, Validators.min(0)]],
      hotelAmenities: [''],
      hotelImageUrl: ['']
    });
  }

  onSubmit(): void {
    this.submitted = true;
    if (this.hotelForm.invalid) return;

    const hotel: HotelInfoDTO = this.hotelForm.value;
    this.hotelService.addHotel(hotel).subscribe({
      next: () => {
        alert('Hotel added successfully!');
        this.router.navigate(['/get-all-hotels']);
      },
      error: (err) => {
        console.error('Error adding hotel:', err);
        alert('Failed to add hotel. Please try again.');
      },
    });
  }

  onCancel(): void {
    this.router.navigate(['/get-all-hotels']);
  }
}
