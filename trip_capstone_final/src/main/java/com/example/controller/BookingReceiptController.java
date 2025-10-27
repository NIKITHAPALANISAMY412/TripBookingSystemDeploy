package com.example.controller;

import com.example.entity.BookingEntity;
import com.example.entity.BookingPassengerEntity;
import com.example.repository.AppBookingRepository;
import com.example.repository.BookingPassengerRepository;
import com.example.service.PDFReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/receipts")
public class BookingReceiptController {

    @Autowired
    private PDFReceiptService pdfReceiptService;

    @Autowired
    private AppBookingRepository bookingRepository;

    @Autowired
    private BookingPassengerRepository passengerRepository;

    //user and admin
    @GetMapping("/download/{bookingId}")
    public ResponseEntity<byte[]> downloadReceipt(@PathVariable Long bookingId) {
        BookingEntity booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        List<BookingPassengerEntity> passengers = passengerRepository.findByBookingId(bookingId);

        byte[] pdfContent = pdfReceiptService.generateBookingReceipt(booking, passengers);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "receipt_" + bookingId + ".pdf");

        return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);
    }
}
