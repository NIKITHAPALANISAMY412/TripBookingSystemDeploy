package com.example.mapper;

import com.example.dto.RoleDTO;
import com.example.entity.RoleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDTO toDTO(RoleEntity entity);
    RoleEntity toEntity(RoleDTO dto);
}
