package com.example.microservice1.web.controller.advice;

import com.example.microservice1.exception.DataMissingException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralControllerAdvice {

    @ExceptionHandler(DataMissingException.class)
    public ResponseEntity<?> onDataMissingException() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({ConstraintViolationException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<?> onConstraintViolationException() {
        return ResponseEntity.badRequest().build();
    }

}
