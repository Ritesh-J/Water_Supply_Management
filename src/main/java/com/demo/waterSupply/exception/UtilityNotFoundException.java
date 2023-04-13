package com.demo.waterSupply.exception;

public class UtilityNotFoundException extends RuntimeException{
    public UtilityNotFoundException(String message) {
        super(message);
    }

    public UtilityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
