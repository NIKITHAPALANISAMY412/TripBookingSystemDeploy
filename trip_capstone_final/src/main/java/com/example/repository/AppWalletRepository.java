package com.example.repository;

import com.example.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AppWalletRepository extends JpaRepository<WalletEntity, Long> {
    Optional<WalletEntity> findByWalletOwnerId(Long userId); // fixed from userId → walletOwner.id
}
