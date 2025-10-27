import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TravelPackageDTO } from '../../../models/TravelPackageDTO.model';
import { TravelPackageService } from '../../../services/travel-package-service';
import { FormControl, FormsModule } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'get-all-active-packages',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './get-all-active-packages.html',
  styleUrl: './get-all-active-packages.css',
})
export class GetAllActivePackages implements OnInit {
  activePackages: TravelPackageDTO[] = [];

  constructor(private packageService: TravelPackageService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadActivePackages();
  }

  loadActivePackages(): void {
    this.packageService.getAllActivePackages().subscribe({
      next: (data) => (this.activePackages = data),
      error: (err) => console.error(err),
    });
  }

  cancel(): void {
  this.router.navigate(['/get-all-packages']);
}

}
