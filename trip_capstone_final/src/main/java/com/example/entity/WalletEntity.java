package com.example.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "app_wallet")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wallet_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity walletOwner;

    @Column(name = "wallet_balance", nullable = false)
    private BigDecimal walletBalance;

    @Column(name = "last_updated", insertable = false, updatable = false)
    private Timestamp lastUpdated;
}
