package com.example.controller;

import com.example.dto.BookingPassengerDTO;
import com.example.service.BookingPassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/booking-passengers")
@Validated
public class BookingPassengerController {

    @Autowired
    private BookingPassengerService bookingPassengerService;

    //admin
    @GetMapping
    public ResponseEntity<List<BookingPassengerDTO>> getAllPassengers() {
        return new ResponseEntity<>(bookingPassengerService.getAllPassengers(), HttpStatus.OK);
    }
    
    //admin
    @GetMapping("/{id}")
    public ResponseEntity<BookingPassengerDTO> getPassenger(@PathVariable Long id) {
        return new ResponseEntity<>(bookingPassengerService.getPassengerById(id), HttpStatus.OK);
    }

    //user and admin
    @PostMapping
    public ResponseEntity<BookingPassengerDTO> addPassenger(@Valid @RequestBody BookingPassengerDTO dto) {
        return new ResponseEntity<>(bookingPassengerService.addPassenger(dto), HttpStatus.OK);
    }

   //user and admin
    @PutMapping("/{id}")
    public ResponseEntity<BookingPassengerDTO> updatePassenger(@Valid @RequestBody BookingPassengerDTO dto, @PathVariable Long id) {
        return new ResponseEntity<>(bookingPassengerService.updatePassenger(dto, id), HttpStatus.OK);
    }

    //user and admin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long id) {
        bookingPassengerService.deletePassenger(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
