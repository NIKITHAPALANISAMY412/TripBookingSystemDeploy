import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { WalletDTO } from '../../../models/WalletDTO.model';
import { WalletService } from '../../../services/wallet-service';


@Component({
  selector: 'get-wallet-by-user-id',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './get-wallet-by-user-id.html',
  styleUrl: './get-wallet-by-user-id.css',
})
export class GetWalletByUserId {
  userId!: number;
  wallet?: WalletDTO;

  constructor(private walletService: WalletService) {}

  getWallet(): void {
    if (!this.userId) return;
    this.walletService.getWalletByUserId(this.userId).subscribe({
      next: (data) => (this.wallet = data),
      error: (err) => {
        console.error(err);
        this.wallet = undefined;
      },
    });
  }
}
