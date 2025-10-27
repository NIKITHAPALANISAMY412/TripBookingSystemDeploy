package com.example.service;

import com.example.dto.WalletTransactionDTO;
import com.example.entity.WalletTransactionEntity;
import com.example.exceptions.IdNotFoundException;
import com.example.mapper.WalletTransactionMapper;
import com.example.repository.WalletTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WalletTransactionService {

    @Autowired
    private WalletTransactionRepository walletTransactionRepository;

    @Autowired
    private WalletTransactionMapper walletTransactionMapper;

    public List<WalletTransactionDTO> getAllTransactions() {
        return walletTransactionRepository.findAll().stream()
                .map(walletTransactionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public WalletTransactionDTO getTransactionById(Long id) {
        WalletTransactionEntity entity = walletTransactionRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("WalletTransaction", "id", id));
        return walletTransactionMapper.toDTO(entity);
    }

    public WalletTransactionDTO addTransaction(WalletTransactionDTO dto) {
        WalletTransactionEntity saved = walletTransactionRepository.saveAndFlush(walletTransactionMapper.toEntity(dto));
        return walletTransactionMapper.toDTO(saved);
    }

    public WalletTransactionDTO updateTransaction(WalletTransactionDTO dto, Long id) {
        WalletTransactionEntity existing = walletTransactionRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("WalletTransaction", "id", id));
        WalletTransactionEntity updated = walletTransactionMapper.toEntity(dto);
        updated.setId(existing.getId());
        return walletTransactionMapper.toDTO(walletTransactionRepository.save(updated));
    }

    public void deleteTransaction(Long id) {
        WalletTransactionEntity entity = walletTransactionRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("WalletTransaction", "id", id));
        walletTransactionRepository.delete(entity);
    }
}
