import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';

import { FormsModule } from '@angular/forms';
import { TransportModeDTO } from '../../../models/TransportModeDTO.model';
import { TransportModeService } from '../../../services/transport-mode-service';

@Component({
  selector: 'get-transports-by-package',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './get-transports-by-package.html',
  styleUrl: './get-transports-by-package.css',
})
export class GetTransportsByPackage implements OnInit {
  transports: TransportModeDTO[] = [];
  packageId!: number;

  constructor(
    private transportService: TransportModeService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.packageId = Number(this.route.snapshot.paramMap.get('packageId'));
    this.loadTransports();
  }

  loadTransports(): void {
    this.transportService.getTransportsByPackageId(this.packageId).subscribe({
      next: (data) => (this.transports = data),
      error: (err) => console.error(err),
    });
  }

  addTransport(): void {
    this.router.navigate(['/add-transport-mode']);
  }

  editTransport(id: number): void {
    this.router.navigate(['/update-transport-mode', id]);
  }

  deleteTransport(id: number): void {
    if (confirm('Are you sure you want to delete this transport mode?')) {
      this.transportService.deleteTransportMode(id).subscribe({
        next: () => this.loadTransports(),
        error: (err) => console.error(err),
      });
    }
  }

  backToAll(): void { this.router.navigate(['/get-all-transport-modes']); }

}
