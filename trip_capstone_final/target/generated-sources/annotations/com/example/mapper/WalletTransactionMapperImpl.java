package com.example.mapper;

import com.example.dto.WalletTransactionDTO;
import com.example.entity.WalletEntity;
import com.example.entity.WalletTransactionEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-27T22:17:18+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251001-1143, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class WalletTransactionMapperImpl implements WalletTransactionMapper {

    @Override
    public WalletTransactionDTO toDTO(WalletTransactionEntity entity) {
        if ( entity == null ) {
            return null;
        }

        WalletTransactionDTO walletTransactionDTO = new WalletTransactionDTO();

        walletTransactionDTO.setWalletId( entityTransactionWalletId( entity ) );
        walletTransactionDTO.setId( entity.getId() );
        walletTransactionDTO.setTransactionAmount( entity.getTransactionAmount() );
        walletTransactionDTO.setTransactionDate( entity.getTransactionDate() );
        walletTransactionDTO.setTransactionType( entity.getTransactionType() );

        return walletTransactionDTO;
    }

    @Override
    public WalletTransactionEntity toEntity(WalletTransactionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        WalletTransactionEntity walletTransactionEntity = new WalletTransactionEntity();

        walletTransactionEntity.setTransactionWallet( mapWalletIdToEntity( dto.getWalletId() ) );
        walletTransactionEntity.setId( dto.getId() );
        walletTransactionEntity.setTransactionAmount( dto.getTransactionAmount() );
        walletTransactionEntity.setTransactionDate( dto.getTransactionDate() );
        walletTransactionEntity.setTransactionType( dto.getTransactionType() );

        return walletTransactionEntity;
    }

    private Long entityTransactionWalletId(WalletTransactionEntity walletTransactionEntity) {
        if ( walletTransactionEntity == null ) {
            return null;
        }
        WalletEntity transactionWallet = walletTransactionEntity.getTransactionWallet();
        if ( transactionWallet == null ) {
            return null;
        }
        Long id = transactionWallet.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
