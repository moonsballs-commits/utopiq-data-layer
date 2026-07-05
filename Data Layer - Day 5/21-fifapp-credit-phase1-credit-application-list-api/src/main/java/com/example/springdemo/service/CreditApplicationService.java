package com.example.springdemo.service;

import java.util.List;
import com.example.springdemo.dto.CreateCreditApplicationRequest;
import com.example.springdemo.dto.CreditApplicationResponse;

public interface CreditApplicationService {
    CreditApplicationResponse createCreditApplication(CreateCreditApplicationRequest request);
    CreditApplicationResponse getCreditApplicationById(Long id);
    List<CreditApplicationResponse> getAllCreditApplications();
}