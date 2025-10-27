package com.example.mapper;

import com.example.dto.WalletDTO;
import com.example.entity.UserEntity;
import com.example.entity.WalletEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-27T22:17:18+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251001-1143, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class WalletMapperImpl implements WalletMapper {

    @Override
    public WalletDTO toDTO(WalletEntity entity) {
        if ( entity == null ) {
            return null;
        }

        WalletDTO walletDTO = new WalletDTO();

        walletDTO.setUserId( entityWalletOwnerId( entity ) );
        walletDTO.setId( entity.getId() );
        walletDTO.setLastUpdated( entity.getLastUpdated() );
        walletDTO.setWalletBalance( entity.getWalletBalance() );

        return walletDTO;
    }

    @Override
    public WalletEntity toEntity(WalletDTO dto) {
        if ( dto == null ) {
            return null;
        }

        WalletEntity walletEntity = new WalletEntity();

        walletEntity.setWalletOwner( walletDTOToUserEntity( dto ) );
        walletEntity.setId( dto.getId() );
        walletEntity.setLastUpdated( dto.getLastUpdated() );
        walletEntity.setWalletBalance( dto.getWalletBalance() );

        return walletEntity;
    }

    private Long entityWalletOwnerId(WalletEntity walletEntity) {
        if ( walletEntity == null ) {
            return null;
        }
        UserEntity walletOwner = walletEntity.getWalletOwner();
        if ( walletOwner == null ) {
            return null;
        }
        Long id = walletOwner.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected UserEntity walletDTOToUserEntity(WalletDTO walletDTO) {
        if ( walletDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( walletDTO.getUserId() );

        return userEntity;
    }
}
