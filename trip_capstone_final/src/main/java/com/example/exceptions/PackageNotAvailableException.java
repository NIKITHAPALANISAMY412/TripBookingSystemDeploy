package com.example.exceptions;

public class PackageNotAvailableException extends RuntimeException {
    private final Long packageId;

    public PackageNotAvailableException(Long packageId) {
        super("Package not available with packageId: " + packageId);
        this.packageId = packageId;
    }
}
