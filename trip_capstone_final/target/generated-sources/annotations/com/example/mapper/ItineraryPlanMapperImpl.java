package com.example.mapper;

import com.example.dto.ItineraryPlanDTO;
import com.example.entity.ItineraryPlanEntity;
import com.example.entity.TravelPackageEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-28T16:59:38+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class ItineraryPlanMapperImpl implements ItineraryPlanMapper {

    @Override
    public ItineraryPlanDTO toDTO(ItineraryPlanEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ItineraryPlanDTO itineraryPlanDTO = new ItineraryPlanDTO();

        itineraryPlanDTO.setPackageId( entityTravelPackageId( entity ) );
        itineraryPlanDTO.setId( entity.getId() );
        itineraryPlanDTO.setDayNumber( entity.getDayNumber() );
        itineraryPlanDTO.setPlaceName( entity.getPlaceName() );
        itineraryPlanDTO.setPlaceDescription( entity.getPlaceDescription() );
        itineraryPlanDTO.setActivities( entity.getActivities() );

        return itineraryPlanDTO;
    }

    @Override
    public ItineraryPlanEntity toEntity(ItineraryPlanDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ItineraryPlanEntity itineraryPlanEntity = new ItineraryPlanEntity();

        itineraryPlanEntity.setTravelPackage( itineraryPlanDTOToTravelPackageEntity( dto ) );
        itineraryPlanEntity.setId( dto.getId() );
        itineraryPlanEntity.setDayNumber( dto.getDayNumber() );
        itineraryPlanEntity.setPlaceName( dto.getPlaceName() );
        itineraryPlanEntity.setPlaceDescription( dto.getPlaceDescription() );
        itineraryPlanEntity.setActivities( dto.getActivities() );

        return itineraryPlanEntity;
    }

    private Long entityTravelPackageId(ItineraryPlanEntity itineraryPlanEntity) {
        if ( itineraryPlanEntity == null ) {
            return null;
        }
        TravelPackageEntity travelPackage = itineraryPlanEntity.getTravelPackage();
        if ( travelPackage == null ) {
            return null;
        }
        Long id = travelPackage.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected TravelPackageEntity itineraryPlanDTOToTravelPackageEntity(ItineraryPlanDTO itineraryPlanDTO) {
        if ( itineraryPlanDTO == null ) {
            return null;
        }

        TravelPackageEntity travelPackageEntity = new TravelPackageEntity();

        travelPackageEntity.setId( itineraryPlanDTO.getPackageId() );

        return travelPackageEntity;
    }
}
