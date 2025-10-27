package com.example.mapper;

import com.example.dto.BookingDTO;
import com.example.entity.BookingEntity;
import com.example.entity.TransportModeEntity;
import com.example.entity.TravelPackageEntity;
import com.example.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-27T22:17:18+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251001-1143, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class BookingMapperImpl implements BookingMapper {

    @Override
    public BookingDTO toDTO(BookingEntity entity) {
        if ( entity == null ) {
            return null;
        }

        BookingDTO bookingDTO = new BookingDTO();

        bookingDTO.setUserId( entityBookedById( entity ) );
        bookingDTO.setPackageId( entityBookedPackageId( entity ) );
        bookingDTO.setTransportId( entityTransportId( entity ) );
        bookingDTO.setBookingDate( entity.getBookingDate() );
        bookingDTO.setBookingStatus( entity.getBookingStatus() );
        bookingDTO.setBookingTotalAmount( entity.getBookingTotalAmount() );
        bookingDTO.setId( entity.getId() );

        return bookingDTO;
    }

    @Override
    public BookingEntity toEntity(BookingDTO dto) {
        if ( dto == null ) {
            return null;
        }

        BookingEntity bookingEntity = new BookingEntity();

        bookingEntity.setBookedBy( mapUserById( dto.getUserId() ) );
        bookingEntity.setBookedPackage( mapPackageById( dto.getPackageId() ) );
        bookingEntity.setTransport( mapTransportById( dto.getTransportId() ) );
        bookingEntity.setBookingDate( dto.getBookingDate() );
        bookingEntity.setBookingStatus( dto.getBookingStatus() );
        bookingEntity.setBookingTotalAmount( dto.getBookingTotalAmount() );
        bookingEntity.setId( dto.getId() );

        return bookingEntity;
    }

    private Long entityBookedById(BookingEntity bookingEntity) {
        if ( bookingEntity == null ) {
            return null;
        }
        UserEntity bookedBy = bookingEntity.getBookedBy();
        if ( bookedBy == null ) {
            return null;
        }
        Long id = bookedBy.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityBookedPackageId(BookingEntity bookingEntity) {
        if ( bookingEntity == null ) {
            return null;
        }
        TravelPackageEntity bookedPackage = bookingEntity.getBookedPackage();
        if ( bookedPackage == null ) {
            return null;
        }
        Long id = bookedPackage.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityTransportId(BookingEntity bookingEntity) {
        if ( bookingEntity == null ) {
            return null;
        }
        TransportModeEntity transport = bookingEntity.getTransport();
        if ( transport == null ) {
            return null;
        }
        Long id = transport.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
