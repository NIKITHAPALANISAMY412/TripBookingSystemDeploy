import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { WalletTransactionDTO } from '../models/WalletTransactionDTO.model';

@Injectable({ providedIn: 'root' })
export class WalletTransactionService {
  private baseUrl = 'http://localhost:9090/api/wallet-transactions'; // matches Spring Boot

  constructor(private httpClient: HttpClient) {}

  getAllTransactions(): Observable<WalletTransactionDTO[]> {
    return this.httpClient.get<WalletTransactionDTO[]>(this.baseUrl); // GET /api/wallet-transactions
  }

  getTransactionById(id: number): Observable<WalletTransactionDTO> {
    return this.httpClient.get<WalletTransactionDTO>(`${this.baseUrl}/${id}`); // GET /api/wallet-transactions/{id}
  }

  addTransaction(dto: WalletTransactionDTO): Observable<WalletTransactionDTO> {
    return this.httpClient.post<WalletTransactionDTO>(this.baseUrl, dto); // POST /api/wallet-transactions
  }

  deleteTransaction(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.baseUrl}/${id}`); // DELETE /api/wallet-transactions/{id}
  }
}
