package com.example.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelPackageDTO {

    private Long id; // optional

    @NotBlank(message = "Package title is required")
    @Size(max = 150)
    private String packageTitle;

    private String packageDescription;
    private String packageSourceCity;
    private String packageDestinationCity;

    @NotNull(message = "Base price is required")
    private Double packageBasePrice;

    private Integer packageDurationDays;
    private Date packageStartDate;
    private Date packageEndDate;
    private Integer packageAvailableSlots;
    private String packageImageUrl;
    private String packageStatus;
    private Timestamp createdAt;
}
