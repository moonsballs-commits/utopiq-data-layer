package com.example.springdemo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditApplicationResponse {
    private Long id;
    private Long customerId;
    private Long vehicleId;
    private BigDecimal loanAmount;
    private Integer tenorMonth;
    private String status;
    private LocalDateTime createdAt;
}