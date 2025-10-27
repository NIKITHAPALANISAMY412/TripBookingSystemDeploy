import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TravelPackageService } from '../../services/travel-package-service';
import { TravelPackageDTO } from '../../models/TravelPackageDTO.model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'header',
  imports: [CommonModule,FormsModule],
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class Header {
  source: string = '';
  destination: string = '';
  fromDate: string = '';
  toDate: string = '';

  constructor(
    private travelPackageService: TravelPackageService,
    private router: Router
  ) {}

  onSearch() {
  if (!this.source || !this.destination || !this.fromDate || !this.toDate) {
    alert('Please fill all fields');
    return;
  }

  // Format dates as yyyy-mm-dd
  const from = new Date(this.fromDate).toISOString().split('T')[0];
  const to = new Date(this.toDate).toISOString().split('T')[0];

  // Navigate to /search-packages with query params
  this.router.navigate(['/search-packages'], {
    queryParams: {
      source: this.source,
      destination: this.destination,
      fromDate: from,
      toDate: to,
    },
  });
}
  logout() {
    localStorage.clear();
    this.router.navigate(['/login']);
  }
}
