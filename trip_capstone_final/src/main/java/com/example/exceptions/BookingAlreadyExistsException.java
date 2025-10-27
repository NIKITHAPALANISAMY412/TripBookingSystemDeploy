package com.example.exceptions;

public class BookingAlreadyExistsException extends RuntimeException {
    private final Long userId;
    private final Long packageId;

    public BookingAlreadyExistsException(Long userId, Long packageId) {
        super("Booking already exists for userId: " + userId + " and packageId: " + packageId);
        this.userId = userId;
        this.packageId = packageId;
    }
}
