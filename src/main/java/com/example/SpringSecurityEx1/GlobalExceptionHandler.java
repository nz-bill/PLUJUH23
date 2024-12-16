package com.example.SpringSecurityEx1;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationExceptions(MethodArgumentNotValidException exceptions){
        Map<String, String> errorList = new HashMap<>();

        exceptions.getBindingResult().getAllErrors().forEach( e ->{
            String field = ((FieldError) e).getField();
            String message = e.getDefaultMessage();
            errorList.put(field,message);

        });
        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }
}
