package com.example.service;

import com.example.dto.BookingPassengerDTO;
import com.example.entity.BookingPassengerEntity;
import com.example.exceptions.IdNotFoundException;
import com.example.mapper.BookingPassengerMapper;
import com.example.repository.BookingPassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingPassengerService {

    @Autowired
    private BookingPassengerRepository bookingPassengerRepository;

    @Autowired
    private BookingPassengerMapper bookingPassengerMapper;

    public List<BookingPassengerDTO> getAllPassengers() {
        return bookingPassengerRepository.findAll().stream()
                .map(bookingPassengerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BookingPassengerDTO getPassengerById(Long id) {
        BookingPassengerEntity entity = bookingPassengerRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("BookingPassenger", "id", id));
        return bookingPassengerMapper.toDTO(entity);
    }

    public BookingPassengerDTO addPassenger(BookingPassengerDTO dto) {
        BookingPassengerEntity saved = bookingPassengerRepository.saveAndFlush(bookingPassengerMapper.toEntity(dto));
        return bookingPassengerMapper.toDTO(saved);
    }

    public BookingPassengerDTO updatePassenger(BookingPassengerDTO dto, Long id) {
        BookingPassengerEntity existing = bookingPassengerRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("BookingPassenger", "id", id));
        BookingPassengerEntity updated = bookingPassengerMapper.toEntity(dto);
        updated.setId(existing.getId());
        return bookingPassengerMapper.toDTO(bookingPassengerRepository.save(updated));
    }

    public void deletePassenger(Long id) {
        BookingPassengerEntity entity = bookingPassengerRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("BookingPassenger", "id", id));
        bookingPassengerRepository.delete(entity);
    }
}
