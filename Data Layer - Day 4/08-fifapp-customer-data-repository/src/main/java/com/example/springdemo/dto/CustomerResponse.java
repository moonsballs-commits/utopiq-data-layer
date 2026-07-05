package com.example.springdemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponse {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("identity_number")
    private String identityNumber;

    @JsonProperty("phone_number")
    private String phoneNumber;
}