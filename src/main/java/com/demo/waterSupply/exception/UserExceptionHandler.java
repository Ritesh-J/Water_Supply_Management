package com.demo.waterSupply.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class UserExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }
    @ExceptionHandler(value = UserNotFoundException.class)

    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException userNotFoundException){
        UserException userException=new UserException(userNotFoundException.getMessage(), userNotFoundException.getCause(),HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(userException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UtilityNotFoundException.class)
    public ResponseEntity<Object> handleUtilityNotFoundException(UtilityNotFoundException utilityNotFoundException){
        UserException userException=new UserException(utilityNotFoundException.getMessage(), utilityNotFoundException.getCause(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(userException, HttpStatus.NOT_FOUND);
    }

}
