package com.demo.waterSupply.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(value = EntityExistsException.class)
    public ResponseEntity<Object> handleEntityExistsException(EntityExistsException entityExistsException){
        UserExceptionMessage userExceptionMessage=new UserExceptionMessage(entityExistsException.getMessage(),entityExistsException.getCause(),HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(userExceptionMessage,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException entityNotFoundException){
        UserExceptionMessage userExceptionMessage=new UserExceptionMessage(entityNotFoundException.getMessage(),entityNotFoundException.getCause(),HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(userExceptionMessage,HttpStatus.NOT_FOUND);
    }


//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
//        Map<String, String> errorMap = new HashMap<>();
//        ex.getBindingResult().getFieldErrors().forEach(error -> {
//            errorMap.put(error.getField(), error.getDefaultMessage());
//        });
//        return errorMap;
//    }
//    @ExceptionHandler(value = EntityNotFoundException.class)
//
//    public ResponseEntity<Object> handleUserNotFoundException(EntityNotFoundException userNotFoundException){
//        UserExceptionMessa userException=new UserExceptionMessa(userNotFoundException.getMessage(), userNotFoundException.getCause(),HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(userException, HttpStatus.NOT_FOUND);
//    }


}
