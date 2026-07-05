package com.example.springdemo.rest;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springdemo.dto.CreateCreditApplicationRequest;
import com.example.springdemo.dto.CreditApplicationResponse;
import com.example.springdemo.service.CreditApplicationService;

@RestController
@RequestMapping("/api/credit-applications")
public class CreditApplicationRestController {

    private final CreditApplicationService creditApplicationService;

    public CreditApplicationRestController(
            CreditApplicationService creditApplicationService) {
        this.creditApplicationService = creditApplicationService;
    }

    @GetMapping
    public List<CreditApplicationResponse> getAllCreditApplications() {
        return creditApplicationService.getAllCreditApplications();
    }
    
    @GetMapping("/{id}")
    public CreditApplicationResponse getCreditApplication(
            @PathVariable Long id) {

        CreditApplicationResponse creditApplication =
                creditApplicationService.getCreditApplicationById(id);

        if (creditApplication == null) {
            throw new RuntimeException(
                    "Credit application not found with id: " + id);
        }

        return creditApplication;
    }

    @PostMapping
    public CreditApplicationResponse createCreditApplication(
            @RequestBody CreateCreditApplicationRequest request) {

        return creditApplicationService.createCreditApplication(request);
    }
}