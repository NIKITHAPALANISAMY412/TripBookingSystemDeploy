package com.example.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletTransactionDTO {

    private Long id; // optional

    @NotNull(message = "Wallet ID is required")
    private Long walletId;

    @NotBlank(message = "Transaction type is required")
    @Pattern(regexp = "CREDIT|DEBIT", message = "Transaction type must be CREDIT or DEBIT")
    private String transactionType;

    @NotNull(message = "Transaction amount is required")
    @DecimalMin(value = "0.01", message = "Transaction amount must be positive")
    private BigDecimal transactionAmount;

    private Timestamp transactionDate; // optional
}
