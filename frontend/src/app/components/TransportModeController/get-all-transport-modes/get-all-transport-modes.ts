import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { TransportModeDTO } from '../../../models/TransportModeDTO.model';
import { TransportModeService } from '../../../services/transport-mode-service';

@Component({
  selector: 'get-all-transport-modes',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './get-all-transport-modes.html',
  styleUrls: ['./get-all-transport-modes.css']
})
// get-all-transport-modes.ts
export class GetAllTransportModes implements OnInit {
  transports: TransportModeDTO[] = [];
  isLoading = true;

  constructor(private transportService: TransportModeService, private router: Router) {}

  ngOnInit(): void { this.loadAllTransports(); }

  loadAllTransports(): void {
    this.transportService.getAllTransportModes().subscribe({
      next: data => { this.transports = data; this.isLoading = false; },
      error: err => { console.error(err); this.isLoading = false; }
    });
  }

  addTransport() { this.router.navigate(['get-all-transport-modes/add-transport-mode']); }
  editTransport(id: number) { this.router.navigate(['get-all-transport-modes//update-transport-mode', id]); }
  deleteTransport(id: number) {
    if(confirm('Delete this transport?')) {
      this.transportService.deleteTransportMode(id).subscribe(() => this.loadAllTransports());
    }
  }
  backToAdmin() { this.router.navigate(['/admindashboard']); }

  viewTransportsByPackage(packageId: number) {
  this.router.navigate([`get-all-transport-modes/transports/package/${packageId}`]);
}

viewAvailableTransports(packageId: number) {
  this.router.navigate([`get-all-transport-modes/available-transports/package/${packageId}`]);
}

}
