package com.example.mapper;

import com.example.dto.HotelInfoDTO;
import com.example.entity.HotelInfoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TravelPackageMapper.class})
public interface HotelInfoMapper {

    @Mapping(source = "travelPackage.id", target = "packageId")
    HotelInfoDTO toDTO(HotelInfoEntity entity);

    @Mapping(target = "travelPackage.id", source = "packageId")
    HotelInfoEntity toEntity(HotelInfoDTO dto);
}
