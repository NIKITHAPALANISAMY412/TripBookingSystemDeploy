package com.example.mapper;

import com.example.dto.ItineraryPlanDTO;
import com.example.entity.ItineraryPlanEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TravelPackageMapper.class})
public interface ItineraryPlanMapper {

    @Mapping(source = "travelPackage.id", target = "packageId")
    ItineraryPlanDTO toDTO(ItineraryPlanEntity entity);

    @Mapping(target = "travelPackage.id", source = "packageId")
    ItineraryPlanEntity toEntity(ItineraryPlanDTO dto);
}
