import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { WalletDTO } from '../../../models/WalletDTO.model';
import { WalletService } from '../../../services/wallet-service';
import { AuthService } from '../../../services/auth-service';

@Component({
  selector: 'add-money-to-wallet',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './add-money-to-wallet.html',
  styleUrls: ['./add-money-to-wallet.css'],
})
export class AddMoneyToWallet implements OnInit {
  amount!: number;
  updatedWallet?: WalletDTO;
  message = '';
  currentWallet?: WalletDTO;

  constructor(
    private walletService: WalletService,
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const userId = this.authService.retrieveUserId() || 2;
    if (!userId) {
      this.message = 'Unable to retrieve user info. Please login.';
      return;
    }

    // Fetch current wallet balance
    this.walletService.getWalletByUserId(userId).subscribe({
      next: (wallet) => {
        this.currentWallet = wallet;
      },
      error: (err) => {
        console.error(err);
        this.message = 'Error fetching wallet balance.';
      },
    });
  }

  addMoney(): void {
    const userId = this.authService.retrieveUserId() ||2;
    if (!userId) {
      this.message = 'Unable to retrieve user info. Please login.';
      return;
    }

    if (!this.amount || this.amount <= 0) {
      this.message = 'Please enter a valid amount.';
      return;
    }

    this.walletService.addMoneyToWallet(userId, this.amount).subscribe({
      next: (wallet) => {
        this.updatedWallet = wallet;
        this.currentWallet = wallet; // update current wallet after adding
        this.message = 'Money added successfully!';
        this.amount = 0; // reset input
      },
      error: (err) => {
        console.error(err);
        this.message = 'Error while adding money.';
      },
    });
  }

  goBack(): void {
    this.router.navigate(['/userdashboard']);
  }
}
