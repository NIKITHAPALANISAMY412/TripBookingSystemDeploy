package com.example.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

    private Long id; // optional for output

    @NotBlank(message = "Role name is required")
    @Size(max = 50)
    private String roleName;
}
