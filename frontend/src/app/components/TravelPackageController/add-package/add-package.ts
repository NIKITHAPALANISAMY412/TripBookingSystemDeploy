import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { TravelPackageDTO } from '../../../models/TravelPackageDTO.model';
import { TravelPackageService } from '../../../services/travel-package-service';


@Component({
  selector: 'add-package',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './add-package.html',
  styleUrl: './add-package.css',
})
export class AddPackage {
  package: TravelPackageDTO = {
    packageTitle: '',
    packageBasePrice: 0,
  };

  constructor(private packageService: TravelPackageService, private router: Router) {}

  addPackage(): void {
    this.packageService.addPackage(this.package).subscribe({
      next: () => this.router.navigate(['/get-all-packages']),
      error: (err) => console.error(err),
    });
  }

  cancel(): void {
  this.router.navigate(['/get-all-packages']);
}

}
