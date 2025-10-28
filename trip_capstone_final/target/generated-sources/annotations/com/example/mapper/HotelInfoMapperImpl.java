package com.example.mapper;

import com.example.dto.HotelInfoDTO;
import com.example.entity.HotelInfoEntity;
import com.example.entity.TravelPackageEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-28T16:59:38+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class HotelInfoMapperImpl implements HotelInfoMapper {

    @Override
    public HotelInfoDTO toDTO(HotelInfoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        HotelInfoDTO hotelInfoDTO = new HotelInfoDTO();

        hotelInfoDTO.setPackageId( entityTravelPackageId( entity ) );
        hotelInfoDTO.setId( entity.getId() );
        hotelInfoDTO.setHotelName( entity.getHotelName() );
        hotelInfoDTO.setHotelLocation( entity.getHotelLocation() );
        hotelInfoDTO.setHotelRating( entity.getHotelRating() );
        hotelInfoDTO.setHotelPricePerNight( entity.getHotelPricePerNight() );
        hotelInfoDTO.setHotelAmenities( entity.getHotelAmenities() );
        hotelInfoDTO.setHotelImageUrl( entity.getHotelImageUrl() );

        return hotelInfoDTO;
    }

    @Override
    public HotelInfoEntity toEntity(HotelInfoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        HotelInfoEntity hotelInfoEntity = new HotelInfoEntity();

        hotelInfoEntity.setTravelPackage( hotelInfoDTOToTravelPackageEntity( dto ) );
        hotelInfoEntity.setId( dto.getId() );
        hotelInfoEntity.setHotelName( dto.getHotelName() );
        hotelInfoEntity.setHotelLocation( dto.getHotelLocation() );
        hotelInfoEntity.setHotelRating( dto.getHotelRating() );
        hotelInfoEntity.setHotelPricePerNight( dto.getHotelPricePerNight() );
        hotelInfoEntity.setHotelAmenities( dto.getHotelAmenities() );
        hotelInfoEntity.setHotelImageUrl( dto.getHotelImageUrl() );

        return hotelInfoEntity;
    }

    private Long entityTravelPackageId(HotelInfoEntity hotelInfoEntity) {
        if ( hotelInfoEntity == null ) {
            return null;
        }
        TravelPackageEntity travelPackage = hotelInfoEntity.getTravelPackage();
        if ( travelPackage == null ) {
            return null;
        }
        Long id = travelPackage.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected TravelPackageEntity hotelInfoDTOToTravelPackageEntity(HotelInfoDTO hotelInfoDTO) {
        if ( hotelInfoDTO == null ) {
            return null;
        }

        TravelPackageEntity travelPackageEntity = new TravelPackageEntity();

        travelPackageEntity.setId( hotelInfoDTO.getPackageId() );

        return travelPackageEntity;
    }
}
