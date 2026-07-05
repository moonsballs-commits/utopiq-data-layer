package com.example.springdemo.service;

import org.springframework.stereotype.Service;
import com.example.springdemo.dao.CreditApplicationRepository;
import com.example.springdemo.dto.CreateCreditApplicationRequest;
import com.example.springdemo.dto.CreditApplicationResponse;
import com.example.springdemo.entity.CreditApplication;

@Service
public class CreditApplicationServiceImpl implements CreditApplicationService {
    private final CreditApplicationRepository creditApplicationRepository;
    public CreditApplicationServiceImpl(CreditApplicationRepository creditApplicationRepository) {
        this.creditApplicationRepository = creditApplicationRepository;
    }

    @Override
    public CreditApplicationResponse createCreditApplication(CreateCreditApplicationRequest request) {
        CreditApplication creditApplication = CreditApplication.builder()
            .customerId(request.getCustomerId())
            .vehicleId(request.getVehicleId())
            .loanAmount(request.getLoanAmount())
            .tenorMonth(request.getTenorMonth())
            .status("PENDING")
            .build();
        CreditApplication savedCreditApplication = creditApplicationRepository.save(creditApplication);
        return toResponse(savedCreditApplication);
    }

    @Override
    public CreditApplicationResponse getCreditApplicationById(Long id) {
        return creditApplicationRepository.findById(id)
            .map(this::toResponse)
            .orElse(null);
    }

    private CreditApplicationResponse toResponse(CreditApplication creditApplication) {
        return CreditApplicationResponse.builder()
            .id(creditApplication.getId())
            .customerId(creditApplication.getCustomerId())
            .vehicleId(creditApplication.getVehicleId())
            .loanAmount(creditApplication.getLoanAmount())
            .tenorMonth(creditApplication.getTenorMonth())
            .status(creditApplication.getStatus())
            .createdAt(creditApplication.getCreatedAt())
            .build();
    }
}