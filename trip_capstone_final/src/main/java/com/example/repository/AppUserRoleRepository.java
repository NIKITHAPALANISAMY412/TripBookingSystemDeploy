package com.example.repository;

import com.example.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppUserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
    List<UserRoleEntity> findByUserId(Long userId);
    List<UserRoleEntity> findByRoleId(Long roleId);
}
