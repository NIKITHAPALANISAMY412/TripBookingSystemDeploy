package com.example.service;

import com.example.dto.UserRequestDTO;
import com.example.dto.UserResponseDTO;
import com.example.entity.RoleEntity;
import com.example.entity.UserEntity;
import com.example.entity.WalletEntity;
import com.example.exceptions.IdNotFoundException;
import com.example.mapper.UserMapper;
import com.example.repository.AppRoleRepository;
import com.example.repository.AppUserRepository;
import com.example.repository.AppWalletRepository;
import com.example.utils.BCryptUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private AppUserRepository userRepository;

    @Autowired
    private AppRoleRepository roleRepository;

    @Autowired
    private AppWalletRepository walletRepository;

    @Autowired
    private UserMapper userMapper;

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public UserResponseDTO getUserById(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("User", "id", id));
        return userMapper.toResponseDTO(user);
    }

     public UserResponseDTO addUser(UserRequestDTO dto) {
    // Hash the password before saving
    String hashedPassword = BCryptUtil.hashPassword(dto.getUserPassword()); // Use the BCryptUtil here

    UserEntity entity = userMapper.toEntity(dto);
    entity.setUserPassword(hashedPassword);  // Set the hashed password

    // handle roles
    Set<RoleEntity> roles = new HashSet<>();
    dto.getRoleIds().forEach(roleId -> {
        RoleEntity role = roleRepository.findById(roleId)
                .orElseThrow(() -> new IdNotFoundException("Role", "id", roleId));
        roles.add(role);
    });
    entity.setRoles(roles);

    UserEntity saved = userRepository.saveAndFlush(entity);

    WalletEntity wallet = new WalletEntity();
    wallet.setWalletOwner(saved);
    wallet.setWalletBalance(BigDecimal.ZERO);
    walletRepository.saveAndFlush(wallet);

    return userMapper.toResponseDTO(saved);
}


    public UserResponseDTO updateUser(UserRequestDTO dto, Long id) {
        UserEntity existing = userRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("User", "id", id));
        UserEntity updated = userMapper.toEntity(dto);
        updated.setId(existing.getId());

        Set<RoleEntity> roles = new HashSet<>();
        dto.getRoleIds().forEach(roleId -> {
            RoleEntity role = roleRepository.findById(roleId)
                    .orElseThrow(() -> new IdNotFoundException("Role", "id", roleId));
            roles.add(role);
        });
        updated.setRoles(roles);

        return userMapper.toResponseDTO(userRepository.save(updated));
    }

    public void deleteUser(Long id) {
        UserEntity existing = userRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("User", "id", id));
        userRepository.delete(existing);
    }

     public Optional<UserResponseDTO> findByUserName(String userName) {
        return userRepository.findByUserName(userName)
                .map(userMapper::toResponseDTO);
    }
}
