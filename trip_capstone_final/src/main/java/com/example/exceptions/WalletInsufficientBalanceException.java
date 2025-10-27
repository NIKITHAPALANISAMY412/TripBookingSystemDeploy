package com.example.exceptions;

public class WalletInsufficientBalanceException extends RuntimeException {
    private final Long userId;
    private final double requiredAmount;

    public WalletInsufficientBalanceException(Long userId, double requiredAmount) {
        super("User " + userId + " has insufficient wallet balance. Required: " + requiredAmount);
        this.userId = userId;
        this.requiredAmount = requiredAmount;
    }
}
