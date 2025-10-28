package com.example.mapper;

import com.example.dto.BookingPassengerDTO;
import com.example.entity.BookingEntity;
import com.example.entity.BookingPassengerEntity;
import java.sql.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-28T16:59:38+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
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
        bookingPassengerDTO.setPassengerName( entity.getPassengerName() );
        bookingPassengerDTO.setPassengerEmail( entity.getPassengerEmail() );
        bookingPassengerDTO.setPassengerPhone( entity.getPassengerPhone() );
        bookingPassengerDTO.setPassengerAge( entity.getPassengerAge() );
        bookingPassengerDTO.setPassengerDob( entity.getPassengerDob() );
        bookingPassengerDTO.setPassengerGender( entity.getPassengerGender() );

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
        bookingPassengerEntity.setPassengerName( dto.getPassengerName() );
        bookingPassengerEntity.setPassengerEmail( dto.getPassengerEmail() );
        bookingPassengerEntity.setPassengerPhone( dto.getPassengerPhone() );
        bookingPassengerEntity.setPassengerAge( dto.getPassengerAge() );
        if ( dto.getPassengerDob() != null ) {
            bookingPassengerEntity.setPassengerDob( new Date( dto.getPassengerDob().getTime() ) );
        }
        bookingPassengerEntity.setPassengerGender( dto.getPassengerGender() );

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
