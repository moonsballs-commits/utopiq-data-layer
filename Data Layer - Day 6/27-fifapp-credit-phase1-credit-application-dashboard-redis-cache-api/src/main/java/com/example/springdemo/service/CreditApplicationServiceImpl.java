package com.example.springdemo.service;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.springdemo.dao.CreditApplicationRepository;
import com.example.springdemo.dao.CustomerRepository;
import com.example.springdemo.dao.VehicleRepository;
import com.example.springdemo.dto.CreateCreditApplicationRequest;
import com.example.springdemo.dto.CreditApplicationDashboardResponse;
import com.example.springdemo.dto.CreditApplicationResponse;
import com.example.springdemo.dto.CreditApplicationSummaryResponse;
import com.example.springdemo.dto.DashboardGroupResponse;
import com.example.springdemo.entity.CreditApplication;
import com.example.springdemo.entity.Customer;
import com.example.springdemo.entity.Vehicle;

@Service
public class CreditApplicationServiceImpl implements CreditApplicationService {
    private static final Long DEFAULT_BRANCH_ID = 10L;
    private final CreditApplicationRepository creditApplicationRepository;
    private final CustomerRepository customerRepository;
    private final VehicleRepository vehicleRepository;

    public CreditApplicationServiceImpl(
        CreditApplicationRepository creditApplicationRepository,
        CustomerRepository customerRepository,
        VehicleRepository vehicleRepository) {
            this.creditApplicationRepository = creditApplicationRepository;
            this.customerRepository = customerRepository;
            this.vehicleRepository = vehicleRepository;
    }

    private CreditApplicationResponse toResponse(CreditApplication creditApplication) {
        return CreditApplicationResponse.builder()
            .id(creditApplication.getId())
            .customerId(creditApplication.getCustomer().getId())
            .vehicleId(creditApplication.getVehicle().getId())
            .loanAmount(creditApplication.getLoanAmount())
            .tenorMonth(creditApplication.getTenorMonth())
            .status(creditApplication.getStatus())
            .createdAt(creditApplication.getCreatedAt())
            .build();
    }

    private List<DashboardGroupResponse> toDashboardGroups(List<Object[]> rows) {
        return rows.stream()
            .map(row -> DashboardGroupResponse.builder()
            .label(String.valueOf(row[0]))
            .applicationCount(toLong(row[1]))
            .totalLoanAmount(toBigDecimal(row[2]))
            .build())
            .toList();
        }
        
    private Long toLong(Object value) {
        if (value == null) {
            return 0L;
        }
        if (value instanceof Number number) {
            return number.longValue();
        }
        return Long.valueOf(String.valueOf(value));
    }
    private BigDecimal toBigDecimal(Object value) {
        if (value == null) {
            return BigDecimal.ZERO;
        }
        if (value instanceof BigDecimal bigDecimal) {
            return bigDecimal;
        }
        if (value instanceof Number number) {
            return BigDecimal.valueOf(number.doubleValue());
        }
        return new BigDecimal(String.valueOf(value));
    }
    
    @Override
    public CreditApplicationResponse createCreditApplication(CreateCreditApplicationRequest request) {
        Customer customer = customerRepository
            .findById(request.getCustomerId())
            .orElseThrow();
        Vehicle vehicle = vehicleRepository
            .findById(request.getVehicleId())
            .orElseThrow();
        CreditApplication creditApplication = CreditApplication.builder()
            .customer(customer)
            .vehicle(vehicle)
            .branchId(request.getBranchId() == null? DEFAULT_BRANCH_ID:request.getBranchId())
            .loanAmount(request.getLoanAmount())
            .tenorMonth(request.getTenorMonth())
            .status("PENDING")
            .build();
        CreditApplication savedCreditApplication = creditApplicationRepository.save(creditApplication);
        return toResponse(savedCreditApplication);
    }

    @Override
    public List<CreditApplicationResponse> getAllCreditApplications(String status) {
        List<CreditApplication> creditApplications;
        if (status != null && !status.isBlank()) {
            creditApplications = creditApplicationRepository.findByStatusWithCustomerAndVehicle(status);
        } else {
            creditApplications = creditApplicationRepository.findAllWithCustomerAndVehicle();
        }
        return creditApplications
            .stream()
            .map(this::toResponse)
            .toList();
    }

    @Override
    public CreditApplicationResponse getCreditApplicationById(Long id) {
        return creditApplicationRepository.findById(id)
            .map(this::toResponse)
            .orElse(null);
    }
    
    @Override
    public CreditApplicationSummaryResponse getSummaryById(Long id) {
        CreditApplication creditApplication = creditApplicationRepository.findById(id)
            .orElse(null);
            if (creditApplication == null) {
                return null;
            }
        return CreditApplicationSummaryResponse.builder()
            .id(creditApplication.getId())
            .status(creditApplication.getStatus())
            .customerName(creditApplication.getCustomer().getFullName())
            .customerPhoneNumber(creditApplication.getCustomer().getPhoneNumber())
            .vehicleName(creditApplication.getVehicle().getBrand() + " " + creditApplication.getVehicle().getModel())
            .plateNumber(creditApplication.getVehicle().getPlateNumber())
            .loanAmount(creditApplication.getLoanAmount())
            .tenorMonth(creditApplication.getTenorMonth())
            .build();
    }
    
    @Override
    public CreditApplicationDashboardResponse getDashboard(Long branchId) {
        Object[] summary = creditApplicationRepository.getDashboardBranch(branchId);
        if (summary == null) {
            return null;
        }
        return CreditApplicationDashboardResponse.builder()
            .branchId(toLong(summary[0]))
            .totalApplications(toLong(summary[1]))
            .totalLoanAmount(toBigDecimal(summary[2]))
            .averageLoanAmount(toBigDecimal(summary[3]))
            .minimumLoanAmount(toBigDecimal(summary[4]))
            .maximumLoanAmount(toBigDecimal(summary[5]))
            .applicationsByStatus(toDashboardGroups(creditApplicationRepository.getDashboardByStatus(branchId)))
            .applicationsByTenorMonth(toDashboardGroups(creditApplicationRepository.getDashboardByTenorMonth(branchId)))
            .applicationsByVehicleBrand(toDashboardGroups(creditApplicationRepository.getDashboardByVehicleBrand(branchId)))
            .build();
    }
}