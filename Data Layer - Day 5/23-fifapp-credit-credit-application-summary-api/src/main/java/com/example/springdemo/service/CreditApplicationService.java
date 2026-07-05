package com.example.springdemo.service;

import java.util.List;
import com.example.springdemo.dto.CreateCreditApplicationRequest;
import com.example.springdemo.dto.CreditApplicationResponse;
import com.example.springdemo.dto.CreditApplicationSummaryResponse;

public interface CreditApplicationService {
    CreditApplicationResponse createCreditApplication(CreateCreditApplicationRequest request);
    List<CreditApplicationResponse> getAllCreditApplications(String status);
    CreditApplicationResponse getCreditApplicationById(Long id);
    CreditApplicationSummaryResponse getSummaryById(Long id);
}