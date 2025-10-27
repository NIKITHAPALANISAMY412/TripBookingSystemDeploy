package com.example.controller;

import com.example.dto.BookingDTO;
import com.example.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/bookings")
@Validated
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Get all bookings,admin
    @GetMapping
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        return new ResponseEntity<>(bookingService.getAllBookings(), HttpStatus.OK);
    }

    // Get booking by ID,admin
    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> getBooking(@PathVariable Long id) {
        return new ResponseEntity<>(bookingService.getBookingById(id), HttpStatus.OK);
    }

    // Get bookings by user ID,user,admin
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookingDTO>> getBookingsByUser(@PathVariable Long userId) {
        return new ResponseEntity<>(bookingService.getBookingsByUserId(userId), HttpStatus.OK);
    }
      
    //userand admin
    @GetMapping("/user/{userId}/status/{status}")
    public ResponseEntity<List<BookingDTO>> getBookingsByUserAndStatus(@PathVariable Long userId, @PathVariable String status) {
        return new ResponseEntity<>(bookingService.getBookingsByUserIdAndStatus(userId, status), HttpStatus.OK);
    }

    // Get bookings by package ID,admin
    @GetMapping("/package/{packageId}")
    public ResponseEntity<List<BookingDTO>> getBookingsByPackage(@PathVariable Long packageId) {
        return new ResponseEntity<>(bookingService.getBookingsByPackageId(packageId), HttpStatus.OK);
    }

    // Add new booking,user
    @PostMapping
    public ResponseEntity<BookingDTO> addBooking(@Valid @RequestBody BookingDTO bookingDTO) {
        return new ResponseEntity<>(bookingService.addBooking(bookingDTO), HttpStatus.OK);
    }

    @PostMapping("/process-payment")
    public ResponseEntity<BookingDTO> processBookingPayment(
            @RequestParam Long userId,
            @RequestParam Long packageId,
            @RequestParam(required = false) Long transportId,
            @RequestParam BigDecimal totalAmount) {
        return new ResponseEntity<>(bookingService.processBookingPayment(userId, packageId, transportId, totalAmount), HttpStatus.OK);
    }

     //user
    @PutMapping("/{id}/cancel")
    public ResponseEntity<BookingDTO> cancelBooking(@PathVariable Long id) {
        return new ResponseEntity<>(bookingService.cancelBooking(id), HttpStatus.OK);
    }

    //user
    // Update existing booking
    @PutMapping("/{id}")
    public ResponseEntity<BookingDTO> updateBooking(@Valid @RequestBody BookingDTO bookingDTO, @PathVariable Long id) {
        bookingDTO.setId(id);
        return new ResponseEntity<>(bookingService.updateBooking(bookingDTO), HttpStatus.OK);
    }

    //user
    // Delete booking
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
