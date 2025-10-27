import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { WalletTransactionDTO } from '../../../models/WalletTransactionDTO.model';
import { WalletService } from '../../../services/wallet-service';
import { AuthService } from '../../../services/auth-service';


@Component({
  selector: 'getwallettransactionbyeachuser',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './getwallettransactionbyeachuser.html',
  styleUrl: './getwallettransactionbyeachuser.css',
})
export class Getwallettransactionbyeachuser {
  transactions: WalletTransactionDTO[] = [];
  message = '';
  userId!: number;

  constructor(private walletService: WalletService, private authService: AuthService) {}

  ngOnInit(): void {
    // Get logged-in user's ID
    this.userId = this.authService.retrieveUserId() || 2;

    if (!this.userId) {
      this.message = 'User not logged in.';
      return;
    }

    // Fetch wallet transactions for the user
    this.walletService.getWalletTransactions(this.userId).subscribe({
      next: (data) => {
        this.transactions = data;
        this.message = data.length ? '' : 'No transactions found.';
      },
      error: (err) => {
        console.error(err);
        this.message = 'Error fetching transactions.';
      }
    });
  }
}