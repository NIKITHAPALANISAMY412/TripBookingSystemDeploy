package com.example.mapper;

import com.example.dto.UserRequestDTO;
import com.example.dto.UserResponseDTO;
import com.example.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-27T22:17:19+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251001-1143, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toEntity(UserRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUserEmail( dto.getUserEmail() );
        userEntity.setUserName( dto.getUserName() );
        userEntity.setUserPassword( dto.getUserPassword() );

        return userEntity;
    }

    @Override
    public UserResponseDTO toResponseDTO(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setUserId( entity.getId() );
        userResponseDTO.setCreatedAt( entity.getCreatedAt() );
        userResponseDTO.setUpdatedAt( entity.getUpdatedAt() );
        userResponseDTO.setUserEmail( entity.getUserEmail() );
        userResponseDTO.setUserName( entity.getUserName() );

        userResponseDTO.setRoles( mapRoles(entity.getRoles()) );

        return userResponseDTO;
    }
}
