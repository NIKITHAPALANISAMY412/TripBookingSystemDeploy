package com.example.repository;

import com.example.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AppBookingRepository extends JpaRepository<BookingEntity, Long> {
    List<BookingEntity> findByBookedById(Long userId);
    List<BookingEntity> findByBookedPackageId(Long packageId);
}
