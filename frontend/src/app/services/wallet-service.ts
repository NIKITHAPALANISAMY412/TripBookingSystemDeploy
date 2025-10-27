import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { WalletDTO } from '../models/WalletDTO.model';
import { WalletTransactionDTO } from '../models/WalletTransactionDTO.model';

@Injectable({ providedIn: 'root' })
export class WalletService {
  private baseUrl = 'http://localhost:9090/api/wallets'; // matches Spring Boot

  constructor(private httpClient: HttpClient) {}

  getAllWallets(): Observable<WalletDTO[]> {
    return this.httpClient.get<WalletDTO[]>(this.baseUrl); // GET /api/wallets
  }

  getWalletById(id: number): Observable<WalletDTO> {
    return this.httpClient.get<WalletDTO>(`${this.baseUrl}/${id}`); // GET /api/wallets/{id}
  }

  getWalletByUserId(userId: number): Observable<WalletDTO> {
    return this.httpClient.get<WalletDTO>(`${this.baseUrl}/user/${userId}`); // GET /api/wallets/user/{userId}
  }

  addMoneyToWallet(userId: number, amount: number): Observable<WalletDTO> {
    return this.httpClient.post<WalletDTO>(`${this.baseUrl}/add-money/${userId}?amount=${amount}`, {}); 
    // POST /api/wallets/add-money/{userId}?amount=...
  }

  getWalletTransactions(userId: number): Observable<WalletTransactionDTO[]> {
    return this.httpClient.get<WalletTransactionDTO[]>(`${this.baseUrl}/transactions/${userId}`); 
    // GET /api/wallets/transactions/{userId}
  }

  deleteWallet(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.baseUrl}/${id}`); // DELETE /api/wallets/{id}
  }
}
