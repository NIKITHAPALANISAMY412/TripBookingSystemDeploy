package com.example.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;
import java.math.BigDecimal;

@Entity
@Table(name = "app_booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity bookedBy;

    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    private TravelPackageEntity bookedPackage;

    @ManyToOne
    @JoinColumn(name = "transport_id")
    private TransportModeEntity transport;

    @Column(name = "booking_total_amount")
    private BigDecimal bookingTotalAmount;

    @Column(name = "booking_status", length = 50)
    private String bookingStatus; // PENDING / CONFIRMED / CANCELLED

    @Column(name = "booking_date", insertable = false, updatable = false)
    private Timestamp bookingDate;
}
