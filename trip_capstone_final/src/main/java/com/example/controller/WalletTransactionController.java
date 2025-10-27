package com.example.controller;

import com.example.dto.WalletTransactionDTO;
import com.example.service.WalletTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/wallet-transactions")
@Validated
public class WalletTransactionController {

    @Autowired
    private WalletTransactionService walletTransactionService;

    //admin
    @GetMapping
    public ResponseEntity<List<WalletTransactionDTO>> getAllTransactions() {
        return new ResponseEntity<>(walletTransactionService.getAllTransactions(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WalletTransactionDTO> getTransaction(@PathVariable Long id) {
        return new ResponseEntity<>(walletTransactionService.getTransactionById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WalletTransactionDTO> addTransaction(@Valid @RequestBody WalletTransactionDTO dto) {
        return new ResponseEntity<>(walletTransactionService.addTransaction(dto), HttpStatus.OK);
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<WalletTransactionDTO> updateTransaction(@Valid @RequestBody WalletTransactionDTO dto, @PathVariable Long id) {
    //     dto.setId(id);
    //     return new ResponseEntity<>(walletTransactionService.updateTransaction(dto), HttpStatus.OK);
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        walletTransactionService.deleteTransaction(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
