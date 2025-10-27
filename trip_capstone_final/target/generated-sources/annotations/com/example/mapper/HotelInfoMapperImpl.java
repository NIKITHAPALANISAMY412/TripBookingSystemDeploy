package com.example.mapper;

import com.example.dto.HotelInfoDTO;
import com.example.entity.HotelInfoEntity;
import com.example.entity.TravelPackageEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-27T22:17:18+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251001-1143, environment: Java 21.0.8 (Eclipse Adoptium)"
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
        hotelInfoDTO.setHotelAmenities( entity.getHotelAmenities() );
        hotelInfoDTO.setHotelImageUrl( entity.getHotelImageUrl() );
        hotelInfoDTO.setHotelLocation( entity.getHotelLocation() );
        hotelInfoDTO.setHotelName( entity.getHotelName() );
        hotelInfoDTO.setHotelPricePerNight( entity.getHotelPricePerNight() );
        hotelInfoDTO.setHotelRating( entity.getHotelRating() );
        hotelInfoDTO.setId( entity.getId() );

        return hotelInfoDTO;
    }

    @Override
    public HotelInfoEntity toEntity(HotelInfoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        HotelInfoEntity hotelInfoEntity = new HotelInfoEntity();

        hotelInfoEntity.setTravelPackage( hotelInfoDTOToTravelPackageEntity( dto ) );
        hotelInfoEntity.setHotelAmenities( dto.getHotelAmenities() );
        hotelInfoEntity.setHotelImageUrl( dto.getHotelImageUrl() );
        hotelInfoEntity.setHotelLocation( dto.getHotelLocation() );
        hotelInfoEntity.setHotelName( dto.getHotelName() );
        hotelInfoEntity.setHotelPricePerNight( dto.getHotelPricePerNight() );
        hotelInfoEntity.setHotelRating( dto.getHotelRating() );
        hotelInfoEntity.setId( dto.getId() );

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
