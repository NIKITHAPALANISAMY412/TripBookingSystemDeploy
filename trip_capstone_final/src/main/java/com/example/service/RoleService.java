package com.example.service;

import com.example.dto.RoleDTO;
import com.example.entity.RoleEntity;
import com.example.exceptions.IdNotFoundException;
import com.example.mapper.RoleMapper;
import com.example.repository.AppRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private AppRoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper;

    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(roleMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RoleDTO getRoleById(Long id) {
        RoleEntity role = roleRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Role", "id", id));
        return roleMapper.toDTO(role);
    }

    public RoleDTO addRole(RoleDTO dto) {
        RoleEntity saved = roleRepository.saveAndFlush(roleMapper.toEntity(dto));
        return roleMapper.toDTO(saved);
    }

    public RoleDTO updateRole(RoleDTO dto, Long id) {
        RoleEntity existing = roleRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Role", "id", id));
        RoleEntity updated = roleMapper.toEntity(dto);
        updated.setId(existing.getId());
        return roleMapper.toDTO(roleRepository.save(updated));
    }

    public void deleteRole(Long id) {
        RoleEntity existing = roleRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Role", "id", id));
        roleRepository.delete(existing);
    }
}
