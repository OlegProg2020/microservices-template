package com.example.microservice1.web.controller.advice;

import com.example.microservice1.exception.DataMissingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralControllerAdvice {

    @ExceptionHandler(DataMissingException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void onDataMissingException() {
    }

}
