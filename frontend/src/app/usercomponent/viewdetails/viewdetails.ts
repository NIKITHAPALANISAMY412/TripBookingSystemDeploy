import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TravelPackageDTO } from '../../models/TravelPackageDTO.model';
import { HotelInfoDTO } from '../../models/HotelInfoDTO.model';
import { ItineraryPlanDTO } from '../../models/ItineraryPlanDTO.model';
import { TransportModeDTO } from '../../models/TransportModeDTO.model';
import { TravelPackageService } from '../../services/travel-package-service';
import { HotelInfoService } from '../../services/hotel-info-service';
import { ItineraryPlanService } from '../../services/itinerary-plan-service';
import { TransportModeService } from '../../services/transport-mode-service';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-viewdetails',
  templateUrl: './viewdetails.html',
  styleUrls: ['./viewdetails.css'],
  imports:[CommonModule],
})
export class Viewdetails implements OnInit {
  packageId!: number;
  travelPackage?: TravelPackageDTO;
  hotels: HotelInfoDTO[] = [];
  itineraries: ItineraryPlanDTO[] = [];
  transports: TransportModeDTO[] = [];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private travelPackageService: TravelPackageService,
    private hotelService: HotelInfoService,
    private itineraryService: ItineraryPlanService,
    private transportService: TransportModeService
  ) {}

  ngOnInit() {
    this.packageId = Number(this.route.snapshot.paramMap.get('id'));

    this.travelPackageService.getPackageById(this.packageId).subscribe({
      next: (pkg) => (this.travelPackage = pkg),
      error: (err) => console.error(err),
    });

    this.hotelService.getHotelsByPackage(this.packageId).subscribe({
      next: (data) => (this.hotels = data),
      error: (err) => console.error(err),
    });

    this.itineraryService.getItineraryByPackage(this.packageId).subscribe({
      next: (data) => (this.itineraries = data),
      error: (err) => console.error(err),
    });

    this.transportService.getTransportsByPackageId(this.packageId).subscribe({
      next: (data) => (this.transports = data),
      error: (err) => console.error(err),
    });
  }

  goBack() {
    this.router.navigate(['/userdashboard']); 
  }
}
