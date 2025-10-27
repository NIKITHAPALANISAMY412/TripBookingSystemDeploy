package com.example.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItineraryPlanDTO {

    private Long id; // optional

    @NotNull(message = "Package ID is required")
    private Long packageId;

    private Integer dayNumber;
    private String placeName;
    private String placeDescription;
    private String activities;
}
