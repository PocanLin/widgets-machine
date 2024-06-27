package com.worldline.interview.exception;

public class ProductionFailedException extends RuntimeException {
    public ProductionFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
