package com.example.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "hotel_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    private TravelPackageEntity travelPackage;

    @Column(name = "hotel_name", length = 100)
    private String hotelName;

    @Column(name = "hotel_location", length = 100)
    private String hotelLocation;

    @Column(name = "hotel_rating", precision = 3, scale = 1)
    private BigDecimal hotelRating;

    @Column(name = "hotel_price_per_night")
    private BigDecimal hotelPricePerNight;

    @Lob
    @Column(name = "hotel_amenities")
    private String hotelAmenities;

    @Column(name = "hotel_image_url", length = 255)
    private String hotelImageUrl;
}
