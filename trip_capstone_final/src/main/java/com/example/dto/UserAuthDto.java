package com.example.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthDto {

   @Pattern(regexp = "^[a-zA-Z0-9_ ]+$", message = "provide a valid username")
   private String userName;


    @Size(min = 8, message = "password should be at least 8 characters")
    private String userPassword;
}
