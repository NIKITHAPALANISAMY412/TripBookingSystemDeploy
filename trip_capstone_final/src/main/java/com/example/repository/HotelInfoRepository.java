package com.example.repository;

import com.example.entity.HotelInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelInfoRepository extends JpaRepository<HotelInfoEntity, Long> {
       List<HotelInfoEntity> findByTravelPackageId(Long packageId);
}
