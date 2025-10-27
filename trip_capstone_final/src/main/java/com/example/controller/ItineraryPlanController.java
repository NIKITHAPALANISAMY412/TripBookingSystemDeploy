package com.example.controller;

import com.example.dto.ItineraryPlanDTO;
import com.example.service.ItineraryPlanService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/itinerary-plans")
@Validated
public class ItineraryPlanController {

    @Autowired
    private ItineraryPlanService itineraryPlanService;

    //user and admin
    @GetMapping
    public ResponseEntity<List<ItineraryPlanDTO>> getAllItineraries() {
        return new ResponseEntity<>(itineraryPlanService.getAllItineraryPlans(), HttpStatus.OK);
    }

    //user and admin
    @GetMapping("/{id}")
    public ResponseEntity<ItineraryPlanDTO> getItinerary(@PathVariable Long id) {
        return new ResponseEntity<>(itineraryPlanService.getItineraryPlanById(id), HttpStatus.OK);
    }

    //admin
    @PostMapping
    public ResponseEntity<ItineraryPlanDTO> addItinerary(@Valid @RequestBody ItineraryPlanDTO dto) {
        return new ResponseEntity<>(itineraryPlanService.addItineraryPlan(dto), HttpStatus.OK);
    }

    //admin
    @PutMapping("/{id}")
    public ResponseEntity<ItineraryPlanDTO> updateItinerary(@Valid @RequestBody ItineraryPlanDTO dto,
                                                            @PathVariable Long id) {
        ItineraryPlanDTO updated = itineraryPlanService.updateItineraryPlan(dto, id);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    //admin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItinerary(@PathVariable Long id) {
        itineraryPlanService.deleteItineraryPlan(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

      @GetMapping("/package/{packageId}")
    public ResponseEntity<List<ItineraryPlanDTO>> getItineraryByPackage(@PathVariable Long packageId) {
        List<ItineraryPlanDTO> itineraries = itineraryPlanService.getItineraryByPackageId(packageId);
        return new ResponseEntity<>(itineraries, HttpStatus.OK);
    }
}
