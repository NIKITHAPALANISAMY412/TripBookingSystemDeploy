import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';

import { CommonModule } from '@angular/common';
import { TravelPackageDTO } from '../../../models/TravelPackageDTO.model';
import { TravelPackageService } from '../../../services/travel-package-service';

@Component({
  selector: 'search-packages',
  standalone: true,
  imports: [CommonModule,RouterModule],
  templateUrl: './search-packages.html',
  styleUrls: ['./search-packages.css'],
})
export class SearchPackagesComponent implements OnInit {
  packages: TravelPackageDTO[] = [];

  constructor(
    private route: ActivatedRoute,
    private travelPackageService: TravelPackageService
  ) {}

  ngOnInit() {
    // Read query params instead of navigation.state
    this.route.queryParams.subscribe((params) => {
      const { source, destination, fromDate, toDate } = params;

      if (source && destination && fromDate && toDate) {
        this.travelPackageService
          .searchPackages(source, destination, fromDate, toDate)
          .subscribe({
            next: (result) => {
              this.packages = result;
              if (!result.length) console.warn('No packages found!');
            },
            error: (err) => console.error('Search failed', err),
          });
      } else {
        console.warn('Missing query params for search');
      }
    });
  }
}
