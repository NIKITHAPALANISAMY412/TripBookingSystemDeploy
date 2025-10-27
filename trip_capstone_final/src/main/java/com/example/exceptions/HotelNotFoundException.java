package com.example.exceptions;

public class HotelNotFoundException extends RuntimeException {
    private final Long hotelId;

    public HotelNotFoundException(Long hotelId) {
        super("Hotel not found with hotelId: " + hotelId);
        this.hotelId = hotelId;
    }
}
