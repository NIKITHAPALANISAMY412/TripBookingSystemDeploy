package com.example.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    private final String email;

    public UserAlreadyExistsException(String email) {
        super("User already exists with email: " + email);
        this.email = email;
    }
}
