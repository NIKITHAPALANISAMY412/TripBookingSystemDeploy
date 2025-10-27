package com.example.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public final class BCryptUtil {

    // Private constructor to prevent instantiation
    private BCryptUtil() {}

    // Use BCrypt with a work factor of 10 (standard)
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    /**
     * Hash the plain password using BCrypt.
     *
     * @param plainPassword the plain password to hash
     * @return the hashed password
     */
    public static String hashPassword(String plainPassword) {
        return passwordEncoder.encode(plainPassword);
    }

    /**
     * Verify if the plain password matches the hashed password.
     *
     * @param plainPassword the plain password
     * @param hashedPassword the hashed password to compare against
     * @return true if the plain password matches the hashed password, false otherwise
     */
    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        return passwordEncoder.matches(plainPassword, hashedPassword);
    }
}
