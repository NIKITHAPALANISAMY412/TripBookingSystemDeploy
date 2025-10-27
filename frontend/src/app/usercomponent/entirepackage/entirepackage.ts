import { Component, OnInit } from '@angular/core';
import { TravelPackageService } from '../../services/travel-package-service';
import { TravelPackageDTO } from '../../models/TravelPackageDTO.model';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-entirepackage',
  templateUrl: './entirepackage.html',
  styleUrls: ['./entirepackage.css'],
  standalone: true,
  imports: [CommonModule, RouterModule],
})
export class Entirepackage implements OnInit {
  packages: TravelPackageDTO[] = [];

  constructor(private travelPackageService: TravelPackageService) {}

  ngOnInit(): void {
    this.travelPackageService.getAllPackages().subscribe({
      next: (data) => (this.packages = data),
      error: (err) => console.error('Error loading packages', err),
    });
  }
}
