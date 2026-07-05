package com.example.springdemo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponse {
    private Long id;
    private String fullName;
    private String identityNumber;
    private String phoneNumber;
}