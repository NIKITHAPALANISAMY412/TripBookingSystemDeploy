import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { HotelInfoService } from '../../../services/hotel-info-service';
import { HotelInfoDTO } from '../../../models/HotelInfoDTO.model';

@Component({
  selector: 'update-hotel',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './update-hotel.html',
  styleUrls: ['./update-hotel.css'],
})
export class UpdateHotel implements OnInit {
  hotelForm!: FormGroup;
  hotelId!: number;
  submitted = false;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private hotelService: HotelInfoService
  ) {}

  ngOnInit(): void {
    this.hotelId = Number(this.route.snapshot.paramMap.get('id'));

    this.hotelForm = this.fb.group({
      packageId: ['', Validators.required],
      hotelName: ['', Validators.required],
      hotelLocation: ['', Validators.required],
      hotelRating: [null, [Validators.required, Validators.min(1), Validators.max(5)]],
      hotelPricePerNight: [null, [Validators.required, Validators.min(0)]],
      hotelAmenities: [''],
      hotelImageUrl: ['']
    });

    this.loadHotelData();
  }

  loadHotelData(): void {
    this.hotelService.getHotelById(this.hotelId).subscribe({
      next: (hotel) => this.hotelForm.patchValue(hotel),
      error: (err) => console.error('Error loading hotel:', err),
    });
  }

  onSubmit(): void {
    this.submitted = true;
    if (this.hotelForm.invalid) return;

    const updatedHotel: HotelInfoDTO = this.hotelForm.value;
    this.hotelService.updateHotel(updatedHotel, this.hotelId).subscribe({
      next: () => {
        alert('Hotel updated successfully!');
        this.router.navigate(['/get-all-hotels']);
      },
      error: (err) => console.error('Error updating hotel:', err),
    });
  }

  onCancel(): void {
    this.router.navigate(['/get-all-hotels']);
  }
}
