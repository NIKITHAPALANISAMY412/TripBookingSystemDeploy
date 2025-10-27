package com.example.mapper;

import com.example.dto.WalletTransactionDTO;
import com.example.entity.WalletEntity;
import com.example.entity.WalletTransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {WalletMapper.class})
public interface WalletTransactionMapper {

    @Mapping(source = "transactionWallet.id", target = "walletId")
    WalletTransactionDTO toDTO(WalletTransactionEntity entity);

    @Mapping(target = "transactionWallet", source = "walletId")
    WalletTransactionEntity toEntity(WalletTransactionDTO dto);

    // custom method to map Long → WalletEntity
    default WalletEntity mapWalletIdToEntity(Long id) {
        if (id == null) return null;
        WalletEntity wallet = new WalletEntity();
        wallet.setId(id);
        return wallet;
    }
}
