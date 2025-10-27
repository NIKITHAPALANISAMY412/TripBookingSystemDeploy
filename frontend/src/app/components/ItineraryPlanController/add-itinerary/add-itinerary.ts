import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule, AbstractControl, FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { ItineraryPlanService } from '../../../services/itinerary-plan-service';
import { ItineraryPlanDTO } from '../../../models/ItineraryPlanDTO.model';

@Component({
  selector: 'add-itinerary',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule,FormsModule],
  templateUrl: './add-itinerary.html',
  styleUrls: ['./add-itinerary.css']
})
export class AddItinerary {
  itineraryForm: FormGroup;
  submitted = false;

  constructor(private fb: FormBuilder, private itineraryService: ItineraryPlanService, private router: Router) {
    this.itineraryForm = this.fb.group({
      packageId: [null, [Validators.required]],
      dayNumber: [null, [Validators.required, Validators.min(1)]],
      placeName: ['', [Validators.required, Validators.maxLength(100)]],
      placeDescription: ['', [Validators.required, Validators.maxLength(255)]],
      activities: ['', [Validators.required, Validators.maxLength(200)]]
    });
  }

  get f(): { [key: string]: AbstractControl } {
    return this.itineraryForm.controls;
  }

  onSubmit(): void {
    this.submitted = true;
    if (this.itineraryForm.invalid) return;

    const itinerary: ItineraryPlanDTO = this.itineraryForm.value;
    this.itineraryService.addItineraryPlan(itinerary).subscribe({
      next: () => {
        alert('Itinerary added successfully!');
        this.router.navigate(['/get-all-itineraries']);
      },
      error: (err) => {
        console.error('Error adding itinerary:', err);
        alert('Failed to add itinerary.');
      }
    });
  }

  onReset(): void {
    this.submitted = false;
    this.itineraryForm.reset();
  }

  cancel(): void { this.router.navigate(['/get-all-itineraries']); }

}

