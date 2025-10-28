package com.example.mapper;

import com.example.dto.TravelPackageDTO;
import com.example.entity.TravelPackageEntity;
import java.sql.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-28T16:59:38+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class TravelPackageMapperImpl implements TravelPackageMapper {

    @Override
    public TravelPackageDTO toDTO(TravelPackageEntity entity) {
        if ( entity == null ) {
            return null;
        }

        TravelPackageDTO travelPackageDTO = new TravelPackageDTO();

        travelPackageDTO.setId( entity.getId() );
        travelPackageDTO.setPackageTitle( entity.getPackageTitle() );
        travelPackageDTO.setPackageDescription( entity.getPackageDescription() );
        travelPackageDTO.setPackageSourceCity( entity.getPackageSourceCity() );
        travelPackageDTO.setPackageDestinationCity( entity.getPackageDestinationCity() );
        travelPackageDTO.setPackageBasePrice( entity.getPackageBasePrice() );
        travelPackageDTO.setPackageDurationDays( entity.getPackageDurationDays() );
        travelPackageDTO.setPackageStartDate( entity.getPackageStartDate() );
        travelPackageDTO.setPackageEndDate( entity.getPackageEndDate() );
        travelPackageDTO.setPackageAvailableSlots( entity.getPackageAvailableSlots() );
        travelPackageDTO.setPackageImageUrl( entity.getPackageImageUrl() );
        travelPackageDTO.setPackageStatus( entity.getPackageStatus() );
        travelPackageDTO.setCreatedAt( entity.getCreatedAt() );

        return travelPackageDTO;
    }

    @Override
    public TravelPackageEntity toEntity(TravelPackageDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TravelPackageEntity travelPackageEntity = new TravelPackageEntity();

        travelPackageEntity.setId( dto.getId() );
        travelPackageEntity.setPackageTitle( dto.getPackageTitle() );
        travelPackageEntity.setPackageDescription( dto.getPackageDescription() );
        travelPackageEntity.setPackageSourceCity( dto.getPackageSourceCity() );
        travelPackageEntity.setPackageDestinationCity( dto.getPackageDestinationCity() );
        travelPackageEntity.setPackageBasePrice( dto.getPackageBasePrice() );
        travelPackageEntity.setPackageDurationDays( dto.getPackageDurationDays() );
        if ( dto.getPackageStartDate() != null ) {
            travelPackageEntity.setPackageStartDate( new Date( dto.getPackageStartDate().getTime() ) );
        }
        if ( dto.getPackageEndDate() != null ) {
            travelPackageEntity.setPackageEndDate( new Date( dto.getPackageEndDate().getTime() ) );
        }
        travelPackageEntity.setPackageAvailableSlots( dto.getPackageAvailableSlots() );
        travelPackageEntity.setPackageImageUrl( dto.getPackageImageUrl() );
        travelPackageEntity.setPackageStatus( dto.getPackageStatus() );
        travelPackageEntity.setCreatedAt( dto.getCreatedAt() );

        return travelPackageEntity;
    }
}
