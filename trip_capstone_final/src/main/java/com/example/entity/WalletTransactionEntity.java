package com.example.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;
import java.math.BigDecimal;

@Entity
@Table(name = "wallet_transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletTransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "wallet_id", nullable = false)
    private WalletEntity transactionWallet;

    @Column(name = "transaction_type", nullable = false, length = 20)
    private String transactionType; // CREDIT / DEBIT

    @Column(name = "transaction_amount", nullable = false)
    private BigDecimal transactionAmount;

    @Column(name = "transaction_date", insertable = false, updatable = false)
    private Timestamp transactionDate;
}
