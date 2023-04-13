package com.demo.waterSupply.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BlankValueException extends RuntimeException{
    public BlankValueException(String message) {
        super(message);
    }

    public BlankValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
