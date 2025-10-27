package com.example.repository;

import com.example.entity.TransportModeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransportModeRepository extends JpaRepository<TransportModeEntity, Long> {

    // Find all transports by package ID
    List<TransportModeEntity> findByTravelPackageId(Long packageId);

    // Optional: Find available transports by package ID and available seats > 0
    List<TransportModeEntity> findByTravelPackageIdAndAvailableSeatsGreaterThan(Long packageId, int seats);
}
