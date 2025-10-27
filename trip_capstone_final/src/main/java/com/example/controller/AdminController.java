package com.example.controller;

import com.example.dto.BookingDTO;
import com.example.dto.WalletDTO;
import com.example.entity.WalletTransactionEntity;
import com.example.service.BookingService;
import com.example.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private WalletService walletService;

    // Admin Dashboard - View all bookings
    @GetMapping("/bookings")
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        return new ResponseEntity<>(bookingService.getAllBookings(), HttpStatus.OK);
    }

    // Admin Dashboard - View admin wallet
    @GetMapping("/wallet")
    public ResponseEntity<WalletDTO> getAdminWallet() {
        return new ResponseEntity<>(walletService.getWalletByUserId(1L), HttpStatus.OK);
    }

    // Admin Dashboard - View all transactions
    @GetMapping("/transactions")
    public ResponseEntity<List<WalletTransactionEntity>> getAdminTransactions() {
        return new ResponseEntity<>(walletService.getWalletTransactions(1L), HttpStatus.OK);
    }

    // Admin - View bookings by status
    @GetMapping("/bookings/status/{status}")
    public ResponseEntity<List<BookingDTO>> getBookingsByStatus(@PathVariable String status) {
        List<BookingDTO> allBookings = bookingService.getAllBookings();
        return new ResponseEntity<>(allBookings.stream()
                .filter(b -> b.getBookingStatus().equals(status))
                .toList(), HttpStatus.OK);
    }

    // Admin - View bookings by package
    @GetMapping("/bookings/package/{packageId}")
    public ResponseEntity<List<BookingDTO>> getBookingsByPackage(@PathVariable Long packageId) {
        return new ResponseEntity<>(bookingService.getBookingsByPackageId(packageId), HttpStatus.OK);
    }
}
