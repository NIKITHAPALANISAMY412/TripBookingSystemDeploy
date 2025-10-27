package com.example.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingPassengerDTO {

    private Long id; // optional

    private Long bookingId;

    private String passengerName;
    private String passengerEmail;
    private String passengerPhone;
    private Integer passengerAge;
    private Date passengerDob;
    private String passengerGender; // MALE / FEMALE / OTHER
}
