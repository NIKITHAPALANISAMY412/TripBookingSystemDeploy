package com.example.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.sql.Time;

@Entity
@Table(name = "transport_mode")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransportModeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transport_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    private TravelPackageEntity travelPackage;

    @Column(name = "transport_type", length = 50)
    private String transportType; // BUS / TRAIN / FLIGHT

    @Column(name = "transport_provider", length = 100)
    private String transportProvider;

    @Column(name = "departure_city", length = 100)
    private String departureCity;

    @Column(name = "arrival_city", length = 100)
    private String arrivalCity;

    @Column(name = "departure_time")
    private Time departureTime;

    @Column(name = "arrival_time")
    private Time arrivalTime;

    @Column(name = "seat_price")
    private BigDecimal seatPrice;

    @Column(name = "available_seats")
    private Integer availableSeats;

    @Column(name = "transport_image_url", length = 255)
    private String transportImageUrl;
}
