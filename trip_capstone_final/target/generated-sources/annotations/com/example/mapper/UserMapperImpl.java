package com.example.mapper;

import com.example.dto.UserRequestDTO;
import com.example.dto.UserResponseDTO;
import com.example.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-28T16:59:38+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toEntity(UserRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUserName( dto.getUserName() );
        userEntity.setUserEmail( dto.getUserEmail() );
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
        userResponseDTO.setUserName( entity.getUserName() );
        userResponseDTO.setUserEmail( entity.getUserEmail() );
        userResponseDTO.setCreatedAt( entity.getCreatedAt() );
        userResponseDTO.setUpdatedAt( entity.getUpdatedAt() );

        userResponseDTO.setRoles( mapRoles(entity.getRoles()) );

        return userResponseDTO;
    }
}
