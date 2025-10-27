// package com.example.dto;

// import jakarta.validation.constraints.*;
// import lombok.*;
// import java.math.BigDecimal;
// import java.sql.Timestamp;

// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class BookingDTO {

//     private Long id; // optional

//     @NotNull(message = "User ID is required")
//     private Long userId;

//     @NotNull(message = "Package ID is required")
//     private Long packageId;

//     private Long transportId;
//     private BigDecimal bookingTotalAmount;
//     private String bookingStatus; // PENDING / CONFIRMED / CANCELLED
//     private Timestamp bookingDate;
// }
package com.example.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {

    private Long id;

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Package ID is required")
    private Long packageId;

    private Long transportId;

    private BigDecimal bookingTotalAmount;
    private String bookingStatus;
    private Timestamp bookingDate;

    // Nested DTOs
    private List<BookingPassengerDTO> passengers;
    private List<ItineraryPlanDTO> itineraryPlans;
    private List<HotelInfoDTO> hotelInfos;
}
