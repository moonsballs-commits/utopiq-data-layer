package com.example.springdemo.exception;

public class DuplicateIdentityNumberException extends RuntimeException {
    public DuplicateIdentityNumberException(String message) {
        super(message);
    }
}