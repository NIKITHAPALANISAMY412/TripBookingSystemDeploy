package com.example.controller;

import com.example.dto.TravelPackageDTO;
import com.example.service.TravelPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.sql.Date;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/travel-packages")
@Validated
public class TravelPackageController {

    @Autowired
    private TravelPackageService travelPackageService;

    //admin and user
    @GetMapping
    public ResponseEntity<List<TravelPackageDTO>> getAllPackages() {
        return new ResponseEntity<>(travelPackageService.getAllPackages(), HttpStatus.OK);
    }

    //admin and user
    @GetMapping("/active")
    public ResponseEntity<List<TravelPackageDTO>> getAllActivePackages() {
        return new ResponseEntity<>(travelPackageService.getAllActivePackages(), HttpStatus.OK);
    }

    //admin and user
    @GetMapping("/{id}")
    public ResponseEntity<TravelPackageDTO> getPackage(@PathVariable Long id) {
        return new ResponseEntity<>(travelPackageService.getPackageById(id), HttpStatus.OK);
    }

    //admin and user
    @GetMapping("/search")
    public ResponseEntity<List<TravelPackageDTO>> searchPackages(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam Date fromDate,
            @RequestParam Date toDate) {
        return new ResponseEntity<>(travelPackageService.searchPackages(source, destination, fromDate, toDate), HttpStatus.OK);
    }

    //admin
    @PostMapping
    public ResponseEntity<TravelPackageDTO> addPackage(@Valid @RequestBody TravelPackageDTO travelPackageDTO) {
        return new ResponseEntity<>(travelPackageService.addPackage(travelPackageDTO), HttpStatus.OK);
    }

    //admin
    @PutMapping("/{id}")
    public ResponseEntity<TravelPackageDTO> updatePackage(@Valid @RequestBody TravelPackageDTO travelPackageDTO, @PathVariable Long id) {
        return new ResponseEntity<>(travelPackageService.updatePackage(travelPackageDTO, id), HttpStatus.OK);
    }

    //admin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackage(@PathVariable Long id) {
        travelPackageService.deletePackage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
