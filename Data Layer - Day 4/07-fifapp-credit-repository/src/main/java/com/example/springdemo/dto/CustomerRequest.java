package com.example.springdemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerRequest {
    @JsonProperty("full_name")
    @NotBlank(message = "Full name is required")
    @Size(min = 3, max = 100,
          message = "Full name must be between 3 and 100 characters")
    @Pattern(
        regexp = "^[A-Za-z ]+$",
        message = "Full name can only contain letters and spaces"
    )
    private String fullName;

    @JsonProperty("identity_number")
    @NotBlank(message = "Identity number is required")
    @Pattern(
        regexp = "^\\d{16}$",
        message = "Identity number must be exactly 16 digits"
    )
    private String identityNumber;

    @JsonProperty("phone_number")
    @NotBlank(message = "Phone number is required")
    @Pattern(
        regexp = "^08\\d{8,11}$",
        message = "Phone number must start with 08 and contain 10-13 digits"
    )
    private String phoneNumber;
}