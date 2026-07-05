package com.example.springdemo.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditApplicationSummaryResponse {
    private Long id;
    private String status;
    private String customerName;
    private String customerPhoneNumber;
    private String vehicleName;
    private String plateNumber;
    private BigDecimal loanAmount;
    private Integer tenorMonth;
}