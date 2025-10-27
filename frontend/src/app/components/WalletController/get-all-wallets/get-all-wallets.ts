import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WalletDTO } from '../../../models/WalletDTO.model';
import { WalletService } from '../../../services/wallet-service';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'get-all-wallets',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './get-all-wallets.html',
  styleUrl: './get-all-wallets.css',
})
export class GetAllWallets implements OnInit {
  wallets: WalletDTO[] = [];

  constructor(private walletService: WalletService, private router: Router) {}

  ngOnInit(): void {
    this.loadWallets();
  }

  loadWallets(): void {
    this.walletService.getAllWallets().subscribe({
      next: (data) => (this.wallets = data),
      error: (err) => console.error('Error loading wallets:', err),
    });
  }

  backToAdmin(): void {
    this.router.navigate(['/admindashboard']);
  }
}
