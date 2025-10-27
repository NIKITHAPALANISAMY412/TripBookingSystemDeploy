package com.example.exceptions;

public class TransactionFailedException extends RuntimeException {
    private final Long walletId;
    private final double amount;

    public TransactionFailedException(Long walletId, double amount) {
        super("Transaction failed for walletId: " + walletId + ", amount: " + amount);
        this.walletId = walletId;
        this.amount = amount;
    }
}
