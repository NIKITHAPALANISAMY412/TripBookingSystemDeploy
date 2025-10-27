import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { TravelPackageDTO } from '../../../models/TravelPackageDTO.model';
import { TravelPackageService } from '../../../services/travel-package-service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'get-all-packages',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './get-all-packages.html',
  styleUrl: './get-all-packages.css',
})
export class GetAllPackages implements OnInit {
  packages: TravelPackageDTO[] = [];

  constructor(private packageService: TravelPackageService, private router: Router) {}

  ngOnInit(): void {
    this.loadPackages();
  }

  loadPackages(): void {
    this.packageService.getAllPackages().subscribe({
      next: (data) => (this.packages = data),
      error: (err) => console.error(err),
    });
  }

  addPackage(): void {
    this.router.navigate(['get-all-packages/add-package']);
  }

  editPackage(id: number): void {
    this.router.navigate(['get-all-packages/update-package', id]);
  }

  deletePackage(id: number): void {
    if (confirm('Are you sure you want to delete this package?')) {
      this.packageService.deletePackage(id).subscribe({
        next: () => this.loadPackages(),
        error: (err) => console.error(err),
      });
    }
  }

  backToAdmin(): void {
    this.router.navigate(['/admindashboard']);
  }

  getAllActivePackages(): void {
    this.router.navigate(['get-all-packages/get-all-active-packages']);
  }
}
