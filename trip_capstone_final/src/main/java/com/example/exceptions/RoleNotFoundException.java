package com.example.exceptions;

public class RoleNotFoundException extends RuntimeException {
    private final Long roleId;

    public RoleNotFoundException(Long roleId) {
        super("Role not found with roleId: " + roleId);
        this.roleId = roleId;
    }
}
