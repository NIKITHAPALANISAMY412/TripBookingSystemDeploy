import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ItineraryPlanDTO } from '../../../models/ItineraryPlanDTO.model';
import { ItineraryPlanService } from '../../../services/itinerary-plan-service';

@Component({
  selector: 'get-all-itineraries',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './get-all-itineraries.html',
  styleUrls: ['./get-all-itineraries.css']
})
export class GetAllItineraries implements OnInit {
  itineraries: ItineraryPlanDTO[] = [];

  constructor(private itineraryService: ItineraryPlanService, private router: Router) {}

  ngOnInit(): void { this.loadItineraries(); }

  loadItineraries(): void {
    this.itineraryService.getAllItineraryPlans().subscribe({
      next: (data) => (this.itineraries = data),
      error: (err) => console.error('Error loading itineraries:', err)
    });
  }

  addItinerary(): void { this.router.navigate(['get-all-itineraries/add-itinerary']); }

  editItinerary(id: number): void { this.router.navigate(['get-all-itineraries/update-itinerary', id]); }

  deleteItinerary(id: number): void {
    if (confirm('Are you sure you want to delete this itinerary?')) {
      this.itineraryService.deleteItineraryPlan(id).subscribe({
        next: () => this.loadItineraries(),
        error: (err) => console.error('Delete failed:', err)
      });
    }
  }

  backToAdmin(): void { this.router.navigate(['/admindashboard']); }
}
