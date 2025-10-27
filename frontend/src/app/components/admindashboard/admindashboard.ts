import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'admindashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './admindashboard.html',
  styleUrls: ['./admindashboard.css'],
})
export class Admindashboard {
  constructor(private router: Router) {}

  navigateTo(section: string): void {
    switch (section) {
      case 'hotels':
        this.router.navigate(['/get-all-hotels']);
        break;
      case 'users':
        this.router.navigate(['/get-all-users']);
        break;
        case 'packages':
      this.router.navigate(['/get-all-packages']);
      break;
      case 'wallets':
        this.router.navigate(['/get-all-wallets']);
        break;
        case 'itineraries': this.router.navigate(['/get-all-itineraries']); break;
         case 'Transport Mode': this.router.navigate(['/get-all-transport-modes']); break;
         case 'transactions':
      this.router.navigate(['/get-all-transactions']);
      break;
      case 'passengers':
  this.router.navigate(['/get-all-passengers']);
  break;
  case 'receipts':
  this.router.navigate(['/download-receipt']);
  break;
  case 'bookings':
        this.router.navigate(['/get-all-bookings']);
        break;


    }
  }
}
