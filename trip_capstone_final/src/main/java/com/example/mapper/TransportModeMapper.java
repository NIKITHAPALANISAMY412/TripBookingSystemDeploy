package com.example.mapper;

import com.example.dto.TransportModeDTO;
import com.example.entity.TransportModeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TravelPackageMapper.class})
public interface TransportModeMapper {

    @Mapping(source = "travelPackage.id", target = "packageId")
    TransportModeDTO toDTO(TransportModeEntity entity);

    @Mapping(target = "travelPackage.id", source = "packageId")
    TransportModeEntity toEntity(TransportModeDTO dto);
}
