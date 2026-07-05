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
public class CreateCreditApplicationRequest {
    private Long customerId;
    private Long vehicleId;
    private Long branchId;
    private BigDecimal loanAmount;
    private Integer tenorMonth;
}