package com.example.microservice1.exception;

public class DataMissingException extends RuntimeException {

    public DataMissingException() {
        super();
    }

    public DataMissingException(String message) {
        super(message);
    }

}
