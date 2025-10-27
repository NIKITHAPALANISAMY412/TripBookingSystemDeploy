import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TransportModeService } from '../../../services/transport-mode-service';
import { TransportModeDTO } from '../../../models/TransportModeDTO.model';


@Component({
  selector: 'add-transport-mode',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './add-transport-mode.html',
  styleUrls: ['./add-transport-mode.css']
})
export class AddTransportMode implements OnInit {
  transportForm!: FormGroup;
  submitted = false;

  constructor(
    private fb: FormBuilder,
    private transportService: TransportModeService,
    private router: Router
  ) {}

  ngOnInit(): void {
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
  }

  onSubmit(): void {
    this.submitted = true;
    if (this.transportForm.invalid) return;

    const dto: TransportModeDTO = this.transportForm.value;

    this.transportService.addTransportMode(dto).subscribe({
      next: () => {
        alert('Transport mode added successfully!');
        this.router.navigate(['/get-all-transport-modes']);
      },
      error: (err) => console.error('Error adding transport mode:', err)
    });
  }

  onCancel(): void {
    this.router.navigate(['/get-all-transport-modes']);
  }
}
