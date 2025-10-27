package com.example.repository;

import com.example.entity.TravelPackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface TravelPackageRepository extends JpaRepository<TravelPackageEntity, Long> {
    
    @Query("SELECT p FROM TravelPackageEntity p WHERE " +
           "p.packageSourceCity = :source AND " +
           "p.packageDestinationCity = :destination AND " +
           "p.packageStartDate >= :fromDate AND " +
           "p.packageEndDate <= :toDate AND " +
           "p.packageStatus = 'ACTIVE'")
    List<TravelPackageEntity> searchPackages(
            @Param("source") String source,
            @Param("destination") String destination,
            @Param("fromDate") Date fromDate,
            @Param("toDate") Date toDate
    );

    List<TravelPackageEntity> findByPackageStatus(String status);

    List<TravelPackageEntity> findByPackageSourceCityAndPackageDestinationCityAndPackageStatus(
            String source, String destination, String status);
}
