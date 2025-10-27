package com.example.mapper;

import com.example.dto.TransportModeDTO;
import com.example.entity.TransportModeEntity;
import com.example.entity.TravelPackageEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-27T22:17:18+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251001-1143, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class TransportModeMapperImpl implements TransportModeMapper {

    @Override
    public TransportModeDTO toDTO(TransportModeEntity entity) {
        if ( entity == null ) {
            return null;
        }

        TransportModeDTO transportModeDTO = new TransportModeDTO();

        transportModeDTO.setPackageId( entityTravelPackageId( entity ) );
        transportModeDTO.setArrivalCity( entity.getArrivalCity() );
        transportModeDTO.setArrivalTime( entity.getArrivalTime() );
        transportModeDTO.setAvailableSeats( entity.getAvailableSeats() );
        transportModeDTO.setDepartureCity( entity.getDepartureCity() );
        transportModeDTO.setDepartureTime( entity.getDepartureTime() );
        transportModeDTO.setId( entity.getId() );
        transportModeDTO.setSeatPrice( entity.getSeatPrice() );
        transportModeDTO.setTransportImageUrl( entity.getTransportImageUrl() );
        transportModeDTO.setTransportProvider( entity.getTransportProvider() );
        transportModeDTO.setTransportType( entity.getTransportType() );

        return transportModeDTO;
    }

    @Override
    public TransportModeEntity toEntity(TransportModeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TransportModeEntity transportModeEntity = new TransportModeEntity();

        transportModeEntity.setTravelPackage( transportModeDTOToTravelPackageEntity( dto ) );
        transportModeEntity.setArrivalCity( dto.getArrivalCity() );
        transportModeEntity.setArrivalTime( dto.getArrivalTime() );
        transportModeEntity.setAvailableSeats( dto.getAvailableSeats() );
        transportModeEntity.setDepartureCity( dto.getDepartureCity() );
        transportModeEntity.setDepartureTime( dto.getDepartureTime() );
        transportModeEntity.setId( dto.getId() );
        transportModeEntity.setSeatPrice( dto.getSeatPrice() );
        transportModeEntity.setTransportImageUrl( dto.getTransportImageUrl() );
        transportModeEntity.setTransportProvider( dto.getTransportProvider() );
        transportModeEntity.setTransportType( dto.getTransportType() );

        return transportModeEntity;
    }

    private Long entityTravelPackageId(TransportModeEntity transportModeEntity) {
        if ( transportModeEntity == null ) {
            return null;
        }
        TravelPackageEntity travelPackage = transportModeEntity.getTravelPackage();
        if ( travelPackage == null ) {
            return null;
        }
        Long id = travelPackage.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected TravelPackageEntity transportModeDTOToTravelPackageEntity(TransportModeDTO transportModeDTO) {
        if ( transportModeDTO == null ) {
            return null;
        }

        TravelPackageEntity travelPackageEntity = new TravelPackageEntity();

        travelPackageEntity.setId( transportModeDTO.getPackageId() );

        return travelPackageEntity;
    }
}
