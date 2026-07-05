package com.example.springdemo.common;

public class DuplicateIdentityNumberException extends RuntimeException {
    public DuplicateIdentityNumberException(String message) {
        super(message);
    }
}