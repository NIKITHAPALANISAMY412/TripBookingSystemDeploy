package com.example.mapper;

import com.example.dto.WalletTransactionDTO;
import com.example.entity.WalletEntity;
import com.example.entity.WalletTransactionEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-28T16:59:38+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
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
        walletTransactionDTO.setTransactionType( entity.getTransactionType() );
        walletTransactionDTO.setTransactionAmount( entity.getTransactionAmount() );
        walletTransactionDTO.setTransactionDate( entity.getTransactionDate() );

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
        walletTransactionEntity.setTransactionType( dto.getTransactionType() );
        walletTransactionEntity.setTransactionAmount( dto.getTransactionAmount() );
        walletTransactionEntity.setTransactionDate( dto.getTransactionDate() );

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
