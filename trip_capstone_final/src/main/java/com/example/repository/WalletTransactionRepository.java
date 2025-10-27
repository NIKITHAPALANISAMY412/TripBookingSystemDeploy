package com.example.repository;

import com.example.entity.WalletTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WalletTransactionRepository extends JpaRepository<WalletTransactionEntity, Long> {
    List<WalletTransactionEntity> findByTransactionWalletId(Long walletId); // fixed from walletId → transactionWallet.id
}
