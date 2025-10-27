package com.example.controller;

import com.example.dto.UserAuthDto;
import com.example.dto.UserResponseDTO;
import com.example.service.JwtService;
import com.example.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    /*
     * Authenticates a user and returns JWT + user info.
     */
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@Valid @RequestBody UserAuthDto userAuthDto) {
        Map<String, Object> response = new HashMap<>();

        try {
            // Authenticate user credentials
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userAuthDto.getUserName(),
                            userAuthDto.getUserPassword()));

            if (authentication.isAuthenticated()) {
                Optional<UserResponseDTO> userDtoOpt = userService.findByUserName(userAuthDto.getUserName());
                if (userDtoOpt.isEmpty()) {
                    throw new UsernameNotFoundException("User not found in database");
                }

                String token = jwtService.generateToken(userAuthDto.getUserName());

                response.put("user", userDtoOpt.get());
                response.put("token", token);
                response.put("message", "Login successful");

                return ResponseEntity.ok(response);
            } else {
                throw new UsernameNotFoundException("Invalid user credentials");
            }

        } catch (Exception e) {
            response.put("message", "Invalid username or password");
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * 🔹 Endpoint: POST /api/auth/validate
     * Used to refresh or validate tokens silently.
     */
    @PostMapping("/validate")
    public ResponseEntity<Map<String, Object>> validate(@Valid @RequestBody UserAuthDto userAuthDto) {
        Map<String, Object> response = new HashMap<>();

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userAuthDto.getUserName(),
                            userAuthDto.getUserPassword()));

            if (authentication.isAuthenticated()) {
                String token = jwtService.generateToken(userAuthDto.getUserName());
                response.put("token", token);
                response.put("message", "Token refreshed successfully");
                return ResponseEntity.ok(response);
            } else {
                throw new UsernameNotFoundException("Invalid credentials");
            }

        } catch (Exception e) {
            response.put("message", "Authentication failed");
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }
}
