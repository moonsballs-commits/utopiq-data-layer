package com.example.springdemo.dto;

import java.time.LocalDateTime;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    @JsonProperty("status")
    private int status;

    @JsonProperty("message")
    private String message;

    @JsonProperty("time_stamp")
    private LocalDateTime timestamp;
    
    @JsonProperty("errors")
    private Map<String, String> errors;
}