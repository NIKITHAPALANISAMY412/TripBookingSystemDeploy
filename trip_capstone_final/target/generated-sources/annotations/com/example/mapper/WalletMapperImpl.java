package com.example.mapper;

import com.example.dto.WalletDTO;
import com.example.entity.UserEntity;
import com.example.entity.WalletEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-28T16:59:38+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
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
        walletDTO.setWalletBalance( entity.getWalletBalance() );
        walletDTO.setLastUpdated( entity.getLastUpdated() );

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
        walletEntity.setWalletBalance( dto.getWalletBalance() );
        walletEntity.setLastUpdated( dto.getLastUpdated() );

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
