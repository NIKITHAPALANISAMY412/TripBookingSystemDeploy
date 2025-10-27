package com.example.mapper;

import com.example.dto.TravelPackageDTO;
import com.example.entity.TravelPackageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {
        HotelInfoMapper.class,
        ItineraryPlanMapper.class,
        TransportModeMapper.class
})
public interface TravelPackageMapper {
    TravelPackageDTO toDTO(TravelPackageEntity entity);
    TravelPackageEntity toEntity(TravelPackageDTO dto);
}
