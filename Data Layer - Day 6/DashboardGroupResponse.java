package id.co.fifpedy.creditphase1creditapplicationdashboard.dto;

import java.math.BigDecimal;

public class DashboardGroupResponse {

    private String label;

    private Long applicationCount;

    private BigDecimal totalLoanAmount;

    public DashboardGroupResponse(String label, Long applicationCount, BigDecimal totalLoanAmount) {
        this.label = label;
        this.applicationCount = applicationCount;
        this.totalLoanAmount = totalLoanAmount;
    }

    public String getLabel() {
        return label;
    }

    public Long getApplicationCount() {
        return applicationCount;
    }

    public BigDecimal getTotalLoanAmount() {
        return totalLoanAmount;
    }
}
