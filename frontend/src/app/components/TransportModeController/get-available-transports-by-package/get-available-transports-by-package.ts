import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { TransportModeDTO } from '../../../models/TransportModeDTO.model';
import { TransportModeService } from '../../../services/transport-mode-service';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'get-available-transports-by-package',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './get-available-transports-by-package.html',
  styleUrl: './get-available-transports-by-package.css',
})
export class GetAvailableTransportsByPackage implements OnInit {
  availableTransports: TransportModeDTO[] = [];
  packageId!: number;

  constructor(
    private route: ActivatedRoute,
    private transportService: TransportModeService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.packageId = Number(this.route.snapshot.paramMap.get('packageId'));
    this.loadAvailableTransports();
  }

  loadAvailableTransports(): void {
    this.transportService.getAvailableTransportsByPackageId(this.packageId).subscribe({
      next: (data) => (this.availableTransports = data),
      error: (err) => console.error(err),
    });
  }
 backToAll(): void { this.router.navigate(['/get-all-transport-modes']); }

}
