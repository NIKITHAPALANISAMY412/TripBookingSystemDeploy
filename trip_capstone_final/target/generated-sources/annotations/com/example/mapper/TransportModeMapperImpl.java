package com.example.mapper;

import com.example.dto.TransportModeDTO;
import com.example.entity.TransportModeEntity;
import com.example.entity.TravelPackageEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-28T16:59:38+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
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
        transportModeDTO.setId( entity.getId() );
        transportModeDTO.setTransportType( entity.getTransportType() );
        transportModeDTO.setTransportProvider( entity.getTransportProvider() );
        transportModeDTO.setDepartureCity( entity.getDepartureCity() );
        transportModeDTO.setArrivalCity( entity.getArrivalCity() );
        transportModeDTO.setDepartureTime( entity.getDepartureTime() );
        transportModeDTO.setArrivalTime( entity.getArrivalTime() );
        transportModeDTO.setSeatPrice( entity.getSeatPrice() );
        transportModeDTO.setAvailableSeats( entity.getAvailableSeats() );
        transportModeDTO.setTransportImageUrl( entity.getTransportImageUrl() );

        return transportModeDTO;
    }

    @Override
    public TransportModeEntity toEntity(TransportModeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TransportModeEntity transportModeEntity = new TransportModeEntity();

        transportModeEntity.setTravelPackage( transportModeDTOToTravelPackageEntity( dto ) );
        transportModeEntity.setId( dto.getId() );
        transportModeEntity.setTransportType( dto.getTransportType() );
        transportModeEntity.setTransportProvider( dto.getTransportProvider() );
        transportModeEntity.setDepartureCity( dto.getDepartureCity() );
        transportModeEntity.setArrivalCity( dto.getArrivalCity() );
        transportModeEntity.setDepartureTime( dto.getDepartureTime() );
        transportModeEntity.setArrivalTime( dto.getArrivalTime() );
        transportModeEntity.setSeatPrice( dto.getSeatPrice() );
        transportModeEntity.setAvailableSeats( dto.getAvailableSeats() );
        transportModeEntity.setTransportImageUrl( dto.getTransportImageUrl() );

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
