package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "itinerary_plan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItineraryPlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itinerary_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    private TravelPackageEntity travelPackage;

    @Column(name = "day_number")
    private Integer dayNumber;

    @Column(name = "place_name", length = 100)
    private String placeName;

    @Lob
    @Column(name = "place_description")
    private String placeDescription;

    @Lob
    @Column(name = "activities")
    private String activities;
}
