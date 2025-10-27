package com.example.dto;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {

    private Long userId;

    private String userName;

    private String userEmail;

    private Set<String> roles;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
