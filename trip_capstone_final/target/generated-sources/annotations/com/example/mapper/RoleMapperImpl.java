package com.example.mapper;

import com.example.dto.RoleDTO;
import com.example.entity.RoleEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-27T22:17:18+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251001-1143, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleDTO toDTO(RoleEntity entity) {
        if ( entity == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId( entity.getId() );
        roleDTO.setRoleName( entity.getRoleName() );

        return roleDTO;
    }

    @Override
    public RoleEntity toEntity(RoleDTO dto) {
        if ( dto == null ) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setId( dto.getId() );
        roleEntity.setRoleName( dto.getRoleName() );

        return roleEntity;
    }
}
