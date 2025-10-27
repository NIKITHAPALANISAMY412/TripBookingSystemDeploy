package com.example.exceptions;

public class TransportNotAvailableException extends RuntimeException {
    private final Long transportId;

    public TransportNotAvailableException(Long transportId) {
        super("Transport not available with transportId: " + transportId);
        this.transportId = transportId;
    }
}
