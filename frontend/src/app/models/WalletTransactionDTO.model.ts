export interface WalletTransactionDTO {
  id?: number;
  walletId: number;
  transactionType: string; // "CREDIT" | "DEBIT"
  transactionAmount: number;
  transactionDate?: string;
}
