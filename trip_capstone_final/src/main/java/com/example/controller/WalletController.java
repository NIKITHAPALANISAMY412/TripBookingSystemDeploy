package com.example.controller;

import com.example.dto.WalletDTO;
import com.example.entity.WalletTransactionEntity;
import com.example.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/wallets")
@Validated
public class WalletController {

    @Autowired
    private WalletService walletService;

    //admin
    @GetMapping
    public ResponseEntity<List<WalletDTO>> getAllWallets() {
        return new ResponseEntity<>(walletService.getAllWallets(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WalletDTO> getWallet(@PathVariable Long id) {
        return new ResponseEntity<>(walletService.getWalletById(id), HttpStatus.OK);
    }

    //user and admin
    @GetMapping("/user/{userId}")
    public ResponseEntity<WalletDTO> getWalletByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(walletService.getWalletByUserId(userId), HttpStatus.OK);
    }

    // @PostMapping
    // public ResponseEntity<WalletDTO> addWallet(@Valid @RequestBody WalletDTO dto) {
    //     return new ResponseEntity<>(walletService.addWallet(dto), HttpStatus.OK);
    // }

    //user
    @PostMapping("/add-money/{userId}")
    public ResponseEntity<WalletDTO> addMoneyToWallet(@PathVariable Long userId, @RequestParam BigDecimal amount) {
        return new ResponseEntity<>(walletService.addMoneyToWallet(userId, amount), HttpStatus.OK);
    }

    //user
    @GetMapping("/transactions/{userId}")
    public ResponseEntity<List<WalletTransactionEntity>> getWalletTransactions(@PathVariable Long userId) {
        return new ResponseEntity<>(walletService.getWalletTransactions(userId), HttpStatus.OK);
    }

    //user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWallet(@PathVariable Long id) {
        walletService.deleteWallet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
