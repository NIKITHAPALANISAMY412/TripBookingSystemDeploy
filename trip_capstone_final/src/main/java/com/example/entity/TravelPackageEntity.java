package com.example.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "travel_package")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelPackageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_id")
    private Long id;

    @Column(name = "package_title", nullable = false, length = 150)
    private String packageTitle;

    @Lob
    @Column(name = "package_description")
    private String packageDescription;

    @Column(name = "package_source_city", length = 100)
    private String packageSourceCity;

    @Column(name = "package_destination_city", length = 100)
    private String packageDestinationCity;

    @Column(name = "package_base_price", nullable = false)
    private Double packageBasePrice;

    @Column(name = "package_duration_days")
    private Integer packageDurationDays;

    @Column(name = "package_start_date")
    private Date packageStartDate;

    @Column(name = "package_end_date")
    private Date packageEndDate;

    @Column(name = "package_available_slots")
    private Integer packageAvailableSlots;

    @Column(name = "package_image_url", length = 255)
    private String packageImageUrl;

    @Column(name = "package_status", length = 50)
    private String packageStatus; // ACTIVE / INACTIVE

    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;
}
