import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TravelPackageDTO } from '../../../models/TravelPackageDTO.model';
import { TravelPackageService } from '../../../services/travel-package-service';


@Component({
  selector: 'update-package',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './update-package.html',
  styleUrl: './update-package.css',
})
export class UpdatePackage implements OnInit {
  packageId!: number;
  package: TravelPackageDTO = { packageTitle: '', packageBasePrice: 0 };

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private packageService: TravelPackageService
  ) {}

  ngOnInit(): void {
    this.packageId = Number(this.route.snapshot.paramMap.get('id'));
    this.loadPackage();
  }

  loadPackage(): void {
    this.packageService.getPackageById(this.packageId).subscribe({
      next: (data) => (this.package = data),
      error: (err) => console.error(err),
    });
  }

  updatePackage(): void {
    this.packageService.updatePackage(this.package, this.packageId).subscribe({
      next: () => this.router.navigate(['/get-all-packages']),
      error: (err) => console.error(err),
    });
  }

  
  cancel(): void {
  this.router.navigate(['/get-all-packages']);
}

}
