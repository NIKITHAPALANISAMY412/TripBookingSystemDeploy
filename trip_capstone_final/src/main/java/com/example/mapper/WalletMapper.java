package com.example.mapper;

import com.example.dto.WalletDTO;
import com.example.entity.WalletEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface WalletMapper {

    @Mapping(source = "walletOwner.id", target = "userId")
    WalletDTO toDTO(WalletEntity entity);

    @Mapping(target = "walletOwner.id", source = "userId")
    WalletEntity toEntity(WalletDTO dto);
}
