import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TransportModeService } from '../../../services/transport-mode-service';
import { TransportModeDTO } from '../../../models/TransportModeDTO.model';


@Component({
  selector: 'update-transport-mode',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './update-transport-mode.html',
  styleUrls: ['./update-transport-mode.css']
})
export class UpdateTransportMode implements OnInit {
  transportForm!: FormGroup;
  transportId!: number;
  submitted = false;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private transportService: TransportModeService
  ) {}

  ngOnInit(): void {
    this.transportId = Number(this.route.snapshot.paramMap.get('id'));
    this.transportForm = this.fb.group({
      packageId: ['', Validators.required],
      transportType: ['', Validators.required],
      transportProvider: [''],
      departureCity: [''],
      arrivalCity: [''],
      departureTime: [''],
      arrivalTime: [''],
      seatPrice: [null, [Validators.required, Validators.min(0)]],
      availableSeats: [null, [Validators.required, Validators.min(1)]],
      transportImageUrl: ['']
    });

    this.loadTransport();
  }

  loadTransport(): void {
    this.transportService.getTransportModeById(this.transportId).subscribe({
      next: (data) => this.transportForm.patchValue(data),
      error: (err) => console.error('Error loading transport mode:', err)
    });
  }

  onSubmit(): void {
    this.submitted = true;
    if (this.transportForm.invalid) return;

    const updatedDto: TransportModeDTO = this.transportForm.value;
    this.transportService.updateTransportMode(updatedDto, this.transportId).subscribe({
      next: () => {
        alert('Transport mode updated successfully!');
        this.router.navigate(['/get-all-transport-modes']);
      },
      error: (err) => console.error('Error updating transport mode:', err)
    });
  }

  onCancel(): void {
    this.router.navigate(['/get-all-transport-modes']);
  }
}
