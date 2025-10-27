import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ItineraryPlanService } from '../../../services/itinerary-plan-service';
import { ItineraryPlanDTO } from '../../../models/ItineraryPlanDTO.model';

@Component({
  selector: 'update-itinerary',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './update-itinerary.html',
  styleUrls: ['./update-itinerary.css']
})
export class UpdateItinerary implements OnInit {
  itineraryForm!: FormGroup;
  itineraryId!: number;

  constructor(
    private fb: FormBuilder,
    private itineraryService: ItineraryPlanService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.itineraryId = +this.route.snapshot.params['id'];
    this.initForm();
    this.loadItinerary();
  }

  initForm(): void {
    this.itineraryForm = this.fb.group({
      packageId: ['', Validators.required],
      dayNumber: ['', Validators.required],
      placeName: ['', Validators.required],
      placeDescription: ['', Validators.required],
      activities: ['', Validators.required]
    });
  }

  loadItinerary(): void {
    this.itineraryService.getItineraryPlanById(this.itineraryId).subscribe({
      next: (data) => this.itineraryForm.patchValue(data),
      error: (err) => console.error('Error loading itinerary:', err)
    });
  }

  onSubmit(): void {
    if (this.itineraryForm.invalid) return;
    const updated = this.itineraryForm.value as ItineraryPlanDTO;
    this.itineraryService.updateItineraryPlan(updated, this.itineraryId).subscribe({
      next: () => { alert('Itinerary updated successfully!'); this.router.navigate(['/get-all-itineraries']); },
      error: (err) => console.error('Update failed:', err)
    });
  }
  cancel(): void { this.router.navigate(['/get-all-itineraries']); }

}
