package com.example.service;

import com.example.dto.WalletDTO;
import com.example.entity.WalletEntity;
import com.example.entity.WalletTransactionEntity;
import com.example.exceptions.IdNotFoundException;
import com.example.mapper.WalletMapper;
import com.example.repository.AppWalletRepository;
import com.example.repository.WalletTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WalletService {

    @Autowired
    private AppWalletRepository walletRepository;

    @Autowired
    private WalletTransactionRepository transactionRepository;

    @Autowired
    private WalletMapper walletMapper;

    public List<WalletDTO> getAllWallets() {
        return walletRepository.findAll().stream()
                .map(walletMapper::toDTO)
                .collect(Collectors.toList());
    }

    public WalletDTO getWalletById(Long id) {
        WalletEntity entity = walletRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Wallet", "id", id));
        return walletMapper.toDTO(entity);
    }

    public WalletDTO getWalletByUserId(Long userId) {
        WalletEntity entity = walletRepository.findByWalletOwnerId(userId)
                .orElseThrow(() -> new IdNotFoundException("Wallet", "userId", userId));
        return walletMapper.toDTO(entity);
    }

    public WalletDTO addWallet(WalletDTO dto) {
        WalletEntity saved = walletRepository.saveAndFlush(walletMapper.toEntity(dto));
        return walletMapper.toDTO(saved);
    }

    public WalletDTO addMoneyToWallet(Long userId, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        WalletEntity wallet = walletRepository.findByWalletOwnerId(userId)
                .orElseThrow(() -> new IdNotFoundException("Wallet", "userId", userId));

        // Add amount to existing balance
        BigDecimal newBalance = wallet.getWalletBalance().add(amount);
        wallet.setWalletBalance(newBalance);
        WalletEntity updated = walletRepository.saveAndFlush(wallet);

        // Record transaction
        WalletTransactionEntity transaction = new WalletTransactionEntity();
        transaction.setTransactionWallet(wallet);
        transaction.setTransactionType("CREDIT");
        transaction.setTransactionAmount(amount);
        transactionRepository.saveAndFlush(transaction);

        return walletMapper.toDTO(updated);
    }

    public WalletDTO debitMoneyFromWallet(Long userId, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        WalletEntity wallet = walletRepository.findByWalletOwnerId(userId)
                .orElseThrow(() -> new IdNotFoundException("Wallet", "userId", userId));

        if (wallet.getWalletBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient wallet balance");
        }

        // Deduct amount from balance
        BigDecimal newBalance = wallet.getWalletBalance().subtract(amount);
        wallet.setWalletBalance(newBalance);
        WalletEntity updated = walletRepository.saveAndFlush(wallet);

        // Record transaction
        WalletTransactionEntity transaction = new WalletTransactionEntity();
        transaction.setTransactionWallet(wallet);
        transaction.setTransactionType("DEBIT");
        transaction.setTransactionAmount(amount);
        transactionRepository.saveAndFlush(transaction);

        return walletMapper.toDTO(updated);
    }

    public List<WalletTransactionEntity> getWalletTransactions(Long userId) {
        WalletEntity wallet = walletRepository.findByWalletOwnerId(userId)
                .orElseThrow(() -> new IdNotFoundException("Wallet", "userId", userId));
        return transactionRepository.findByTransactionWalletId(wallet.getId());
    }

    public WalletDTO updateWallet(WalletDTO dto, Long id) {
        WalletEntity existing = walletRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Wallet", "id", id));
        WalletEntity updated = walletMapper.toEntity(dto);
        updated.setId(existing.getId());
        return walletMapper.toDTO(walletRepository.save(updated));
    }

    public void deleteWallet(Long id) {
        WalletEntity entity = walletRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Wallet", "id", id));
        walletRepository.delete(entity);
    }
}
