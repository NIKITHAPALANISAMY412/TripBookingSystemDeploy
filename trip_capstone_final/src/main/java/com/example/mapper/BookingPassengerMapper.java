package com.example.mapper;

import com.example.dto.BookingPassengerDTO;
import com.example.entity.BookingPassengerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {BookingMapper.class})
public interface BookingPassengerMapper {

    @Mapping(source = "booking.id", target = "bookingId")
    BookingPassengerDTO toDTO(BookingPassengerEntity entity);

    @Mapping(target = "booking.id", source = "bookingId")
    BookingPassengerEntity toEntity(BookingPassengerDTO dto);
}
