package com.example.controller;

import com.example.dto.HotelInfoDTO;
import com.example.service.HotelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/hotels")
@Validated
public class HotelInfoController {

    @Autowired
    private HotelInfoService hotelInfoService;

    //user and admin
    @GetMapping
    public ResponseEntity<List<HotelInfoDTO>> getAllHotels() {
        return new ResponseEntity<>(hotelInfoService.getAllHotels(), HttpStatus.OK);
    }

    //admin and user
    @GetMapping("/{id}")
    public ResponseEntity<HotelInfoDTO> getHotel(@PathVariable Long id) {
        return new ResponseEntity<>(hotelInfoService.getHotelById(id), HttpStatus.OK);
    }

     //admin
    @PostMapping
    public ResponseEntity<HotelInfoDTO> addHotel(@Valid @RequestBody HotelInfoDTO dto) {
        return new ResponseEntity<>(hotelInfoService.addHotel(dto), HttpStatus.OK);
    }

    //admin
    @PutMapping("/{id}")
    public ResponseEntity<HotelInfoDTO> updateHotel(@Valid @RequestBody HotelInfoDTO dto, @PathVariable Long id) {
        return new ResponseEntity<>(hotelInfoService.updateHotel(dto, id), HttpStatus.OK);
    }

    //admin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelInfoService.deleteHotel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


     @GetMapping("/package/{packageId}")
    public ResponseEntity<List<HotelInfoDTO>> getHotelsByPackage(@PathVariable Long packageId) {
        List<HotelInfoDTO> hotels = hotelInfoService.getHotelsByPackageId(packageId);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }
}
