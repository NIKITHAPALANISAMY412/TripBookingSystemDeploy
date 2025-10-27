package com.example.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    @NotBlank(message = "User name is required")
    @Size(max = 100)
    private String userName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String userEmail;

    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 255)
    private String userPassword;

    @NotEmpty(message = "At least one role is required")
    private Set<Long> roleIds;

}
