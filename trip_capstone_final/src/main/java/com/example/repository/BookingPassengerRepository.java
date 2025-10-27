package com.example.repository;

import com.example.entity.BookingPassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingPassengerRepository extends JpaRepository<BookingPassengerEntity, Long> {
    List<BookingPassengerEntity> findByBookingId(Long bookingId);
}
