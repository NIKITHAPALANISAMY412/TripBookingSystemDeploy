import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { WalletTransactionDTO } from '../../../models/WalletTransactionDTO.model';
import { WalletTransactionService } from '../../../services/wallet-transaction-service';

@Component({
  selector: 'get-all-transactions',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './get-all-transactions.html',
  styleUrl: './get-all-transactions.css',
})
export class GetAllTransactions implements OnInit {
  transactions: WalletTransactionDTO[] = [];

  constructor(private walletTransactionService: WalletTransactionService, private router: Router) {}

  ngOnInit(): void {
    this.loadTransactions();
  }

  loadTransactions(): void {
    this.walletTransactionService.getAllTransactions().subscribe({
      next: (data) => (this.transactions = data),
      error: (err) => console.error('Error loading transactions:', err),
    });
  }

  backToAdmin(): void {
    this.router.navigate(['/admindashboard']);
  }
}
