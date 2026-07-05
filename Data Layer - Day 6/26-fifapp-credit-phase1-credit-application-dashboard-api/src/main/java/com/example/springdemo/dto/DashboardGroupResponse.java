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
public class DashboardGroupResponse {
    private String label;
    private Long applicationCount;
    private BigDecimal totalLoanAmount;
}