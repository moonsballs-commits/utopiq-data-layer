package com.example.springdemo.dto;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditApplicationDashboardResponse {
    private Long branchId;
    private Long totalApplications;
    private BigDecimal totalLoanAmount;
    private BigDecimal averageLoanAmount;
    private BigDecimal minimumLoanAmount;
    private BigDecimal maximumLoanAmount;
    private List<DashboardGroupResponse> applicationsByStatus;
    private List<DashboardGroupResponse> applicationsByTenorMonth;
    private List<DashboardGroupResponse> applicationsByVehicleBrand;
}