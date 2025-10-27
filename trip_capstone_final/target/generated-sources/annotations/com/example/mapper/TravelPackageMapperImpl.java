package com.example.mapper;

import com.example.dto.TravelPackageDTO;
import com.example.entity.TravelPackageEntity;
import java.sql.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-27T22:17:18+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251001-1143, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class TravelPackageMapperImpl implements TravelPackageMapper {

    @Override
    public TravelPackageDTO toDTO(TravelPackageEntity entity) {
        if ( entity == null ) {
            return null;
        }

        TravelPackageDTO travelPackageDTO = new TravelPackageDTO();

        travelPackageDTO.setCreatedAt( entity.getCreatedAt() );
        travelPackageDTO.setId( entity.getId() );
        travelPackageDTO.setPackageAvailableSlots( entity.getPackageAvailableSlots() );
        travelPackageDTO.setPackageBasePrice( entity.getPackageBasePrice() );
        travelPackageDTO.setPackageDescription( entity.getPackageDescription() );
        travelPackageDTO.setPackageDestinationCity( entity.getPackageDestinationCity() );
        travelPackageDTO.setPackageDurationDays( entity.getPackageDurationDays() );
        travelPackageDTO.setPackageEndDate( entity.getPackageEndDate() );
        travelPackageDTO.setPackageImageUrl( entity.getPackageImageUrl() );
        travelPackageDTO.setPackageSourceCity( entity.getPackageSourceCity() );
        travelPackageDTO.setPackageStartDate( entity.getPackageStartDate() );
        travelPackageDTO.setPackageStatus( entity.getPackageStatus() );
        travelPackageDTO.setPackageTitle( entity.getPackageTitle() );

        return travelPackageDTO;
    }

    @Override
    public TravelPackageEntity toEntity(TravelPackageDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TravelPackageEntity travelPackageEntity = new TravelPackageEntity();

        travelPackageEntity.setCreatedAt( dto.getCreatedAt() );
        travelPackageEntity.setId( dto.getId() );
        travelPackageEntity.setPackageAvailableSlots( dto.getPackageAvailableSlots() );
        travelPackageEntity.setPackageBasePrice( dto.getPackageBasePrice() );
        travelPackageEntity.setPackageDescription( dto.getPackageDescription() );
        travelPackageEntity.setPackageDestinationCity( dto.getPackageDestinationCity() );
        travelPackageEntity.setPackageDurationDays( dto.getPackageDurationDays() );
        if ( dto.getPackageEndDate() != null ) {
            travelPackageEntity.setPackageEndDate( new Date( dto.getPackageEndDate().getTime() ) );
        }
        travelPackageEntity.setPackageImageUrl( dto.getPackageImageUrl() );
        travelPackageEntity.setPackageSourceCity( dto.getPackageSourceCity() );
        if ( dto.getPackageStartDate() != null ) {
            travelPackageEntity.setPackageStartDate( new Date( dto.getPackageStartDate().getTime() ) );
        }
        travelPackageEntity.setPackageStatus( dto.getPackageStatus() );
        travelPackageEntity.setPackageTitle( dto.getPackageTitle() );

        return travelPackageEntity;
    }
}
