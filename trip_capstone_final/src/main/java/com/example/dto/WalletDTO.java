package com.example.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletDTO {

    private Long id; // optional

    @NotNull(message = "User ID is required")
    private Long userId;

    @DecimalMin(value = "0.0", inclusive = true, message = "Wallet balance cannot be negative")
    private BigDecimal walletBalance;

    private Timestamp lastUpdated; // optional
}
