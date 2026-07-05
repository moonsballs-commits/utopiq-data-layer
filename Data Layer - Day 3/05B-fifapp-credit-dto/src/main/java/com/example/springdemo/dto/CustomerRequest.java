package com.example.springdemo.dto;

import lombok.Data;

@Data
public class CustomerRequest {
    private String fullName;
    private String identityNumber;
    private String phoneNumber;
}