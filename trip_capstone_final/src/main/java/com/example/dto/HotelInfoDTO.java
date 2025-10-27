package com.example.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelInfoDTO {

    private Long id; // optional

    @NotNull(message = "Package ID is required")
    private Long packageId;

    private String hotelName;
    private String hotelLocation;
    private BigDecimal hotelRating;
    private BigDecimal hotelPricePerNight;
    private String hotelAmenities;
    private String hotelImageUrl;
}
