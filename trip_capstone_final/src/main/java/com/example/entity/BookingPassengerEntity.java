package com.example.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;

@Entity
@Table(name = "booking_passenger")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingPassengerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private BookingEntity booking;

    @Column(name = "passenger_name", length = 100)
    private String passengerName;

    @Column(name = "passenger_email", length = 100)
    private String passengerEmail;

    @Column(name = "passenger_phone", length = 20)
    private String passengerPhone;

    @Column(name = "passenger_age")
    private Integer passengerAge;

    @Column(name = "passenger_dob")
    private Date passengerDob;

    @Column(name = "passenger_gender", length = 20)
    private String passengerGender; // MALE / FEMALE / OTHER
}
