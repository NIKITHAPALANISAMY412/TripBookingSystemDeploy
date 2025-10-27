package com.example.exceptions;

public class InvalidBookingStatusException extends RuntimeException {
    private final Long bookingId;
    private final String currentStatus;
    private final String attemptedStatus;

    public InvalidBookingStatusException(Long bookingId, String currentStatus, String attemptedStatus) {
        super("Cannot change booking " + bookingId + " from " + currentStatus + " to " + attemptedStatus);
        this.bookingId = bookingId;
        this.currentStatus = currentStatus;
        this.attemptedStatus = attemptedStatus;
    }
}
