package com.example.controller;

import com.example.dto.UserRequestDTO;
import com.example.dto.UserResponseDTO;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    //admin
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    //user and admin
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    //user and admin
    @PostMapping
    public ResponseEntity<UserResponseDTO> addUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        return new ResponseEntity<>(userService.addUser(userRequestDTO), HttpStatus.OK);
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<UserResponseDTO> updateUser(@Valid @RequestBody UserRequestDTO userRequestDTO, @PathVariable Long id) {
    //     return new ResponseEntity<>(userService.updateUser(id, userRequestDTO), HttpStatus.OK);
    // }

    //user and admin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
