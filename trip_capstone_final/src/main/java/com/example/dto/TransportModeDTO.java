package com.example.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransportModeDTO {

    private Long id; // optional

    @NotNull(message = "Package ID is required")
    private Long packageId;

    private String transportType;
    private String transportProvider;
    private String departureCity;
    private String arrivalCity;
    private Time departureTime;
    private Time arrivalTime;
    private BigDecimal seatPrice;
    private Integer availableSeats;
    private String transportImageUrl;
}
