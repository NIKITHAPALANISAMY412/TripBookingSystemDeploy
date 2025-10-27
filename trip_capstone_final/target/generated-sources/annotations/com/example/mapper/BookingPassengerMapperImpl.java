package com.example.mapper;

import com.example.dto.BookingPassengerDTO;
import com.example.entity.BookingEntity;
import com.example.entity.BookingPassengerEntity;
import java.sql.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-27T22:17:18+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251001-1143, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class BookingPassengerMapperImpl implements BookingPassengerMapper {

    @Override
    public BookingPassengerDTO toDTO(BookingPassengerEntity entity) {
        if ( entity == null ) {
            return null;
        }

        BookingPassengerDTO bookingPassengerDTO = new BookingPassengerDTO();

        bookingPassengerDTO.setBookingId( entityBookingId( entity ) );
        bookingPassengerDTO.setId( entity.getId() );
        bookingPassengerDTO.setPassengerAge( entity.getPassengerAge() );
        bookingPassengerDTO.setPassengerDob( entity.getPassengerDob() );
        bookingPassengerDTO.setPassengerEmail( entity.getPassengerEmail() );
        bookingPassengerDTO.setPassengerGender( entity.getPassengerGender() );
        bookingPassengerDTO.setPassengerName( entity.getPassengerName() );
        bookingPassengerDTO.setPassengerPhone( entity.getPassengerPhone() );

        return bookingPassengerDTO;
    }

    @Override
    public BookingPassengerEntity toEntity(BookingPassengerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        BookingPassengerEntity bookingPassengerEntity = new BookingPassengerEntity();

        bookingPassengerEntity.setBooking( bookingPassengerDTOToBookingEntity( dto ) );
        bookingPassengerEntity.setId( dto.getId() );
        bookingPassengerEntity.setPassengerAge( dto.getPassengerAge() );
        if ( dto.getPassengerDob() != null ) {
            bookingPassengerEntity.setPassengerDob( new Date( dto.getPassengerDob().getTime() ) );
        }
        bookingPassengerEntity.setPassengerEmail( dto.getPassengerEmail() );
        bookingPassengerEntity.setPassengerGender( dto.getPassengerGender() );
        bookingPassengerEntity.setPassengerName( dto.getPassengerName() );
        bookingPassengerEntity.setPassengerPhone( dto.getPassengerPhone() );

        return bookingPassengerEntity;
    }

    private Long entityBookingId(BookingPassengerEntity bookingPassengerEntity) {
        if ( bookingPassengerEntity == null ) {
            return null;
        }
        BookingEntity booking = bookingPassengerEntity.getBooking();
        if ( booking == null ) {
            return null;
        }
        Long id = booking.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected BookingEntity bookingPassengerDTOToBookingEntity(BookingPassengerDTO bookingPassengerDTO) {
        if ( bookingPassengerDTO == null ) {
            return null;
        }

        BookingEntity bookingEntity = new BookingEntity();

        bookingEntity.setId( bookingPassengerDTO.getBookingId() );

        return bookingEntity;
    }
}
