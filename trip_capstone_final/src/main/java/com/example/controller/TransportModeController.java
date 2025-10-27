package com.example.controller;

import com.example.dto.TransportModeDTO;
import com.example.service.TransportModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/transport-modes")
@Validated
public class TransportModeController {

    @Autowired
    private TransportModeService transportModeService;

    //admin and user
    @GetMapping
    public ResponseEntity<List<TransportModeDTO>> getAllTransportModes() {
        return new ResponseEntity<>(transportModeService.getAllTransportModes(), HttpStatus.OK);
    }

    //user and admin
    @GetMapping("/{id}")
    public ResponseEntity<TransportModeDTO> getTransportMode(@PathVariable Long id) {
        return new ResponseEntity<>(transportModeService.getTransportModeById(id), HttpStatus.OK);
    }

    //admin and user
    @GetMapping("/package/{packageId}")
    public ResponseEntity<List<TransportModeDTO>> getTransportsByPackage(@PathVariable Long packageId) {
        return new ResponseEntity<>(transportModeService.getTransportsByPackageId(packageId), HttpStatus.OK);
    }

    //admin and user
    @GetMapping("/package/{packageId}/available")
    public ResponseEntity<List<TransportModeDTO>> getAvailableTransportsByPackage(@PathVariable Long packageId) {
        return new ResponseEntity<>(transportModeService.getAvailableTransportsByPackageId(packageId), HttpStatus.OK);
    }

    //admin
    @PostMapping
    public ResponseEntity<TransportModeDTO> addTransportMode(@Valid @RequestBody TransportModeDTO dto) {
        return new ResponseEntity<>(transportModeService.addTransportMode(dto), HttpStatus.OK);
    }

    //admin
    @PutMapping("/{id}")
    public ResponseEntity<TransportModeDTO> updateTransportMode(@Valid @RequestBody TransportModeDTO dto, @PathVariable Long id) {
        return new ResponseEntity<>(transportModeService.updateTransportMode(dto, id), HttpStatus.OK);
    }

    //admin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransportMode(@PathVariable Long id) {
        transportModeService.deleteTransportMode(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
