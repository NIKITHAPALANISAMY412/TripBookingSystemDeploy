package com.example.repository;

import com.example.entity.ItineraryPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItineraryPlanRepository extends JpaRepository<ItineraryPlanEntity, Long> {
    // Use the correct field name from ItineraryPlanEntity
   List<ItineraryPlanEntity> findByTravelPackageId(Long packageId);

}
