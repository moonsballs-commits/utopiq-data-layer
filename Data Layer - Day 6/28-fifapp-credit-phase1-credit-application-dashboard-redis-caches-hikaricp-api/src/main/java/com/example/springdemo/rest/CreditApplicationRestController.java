package com.example.springdemo.rest;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.springdemo.dto.CreateCreditApplicationRequest;
import com.example.springdemo.dto.CreditApplicationDashboardResponse;
import com.example.springdemo.dto.CreditApplicationResponse;
import com.example.springdemo.dto.CreditApplicationSummaryResponse;
import com.example.springdemo.service.CreditApplicationService;

@RestController
@RequestMapping("/api/credit-applications")
public class CreditApplicationRestController {
    private final CreditApplicationService creditApplicationService;

    public CreditApplicationRestController(
            CreditApplicationService creditApplicationService) {
        this.creditApplicationService = creditApplicationService;
    }

    @PostMapping
    public CreditApplicationResponse createCreditApplication(
            @RequestBody CreateCreditApplicationRequest request) {

        return creditApplicationService.createCreditApplication(request);
    }

    @GetMapping
    public List<CreditApplicationResponse> getAllCreditApplications(@RequestParam(required = false) String status) {
        return creditApplicationService
            .getAllCreditApplications(status);
    }
    
    @GetMapping("/{id}")
    public CreditApplicationResponse getCreditApplicationById(@PathVariable Long id) {

        CreditApplicationResponse creditApplication =
                creditApplicationService.getCreditApplicationById(id);

        if (creditApplication == null) {
            throw new RuntimeException(
                "Credit application not found with id: " + id);
        }
        return creditApplication;
    }

    @GetMapping("/{id}/summary")
    public CreditApplicationSummaryResponse getSummaryById(@PathVariable Long id) {
    CreditApplicationSummaryResponse creditApplicationSummary = creditApplicationService.getSummaryById(id);
    if (creditApplicationSummary == null) {
        throw new RuntimeException(
            "Credit application not found with id: " + id);
        }
        return creditApplicationSummary;
    }

    @GetMapping("/dashboard")
    public CreditApplicationDashboardResponse getDashboard(@RequestParam Long branchId) {
        CreditApplicationDashboardResponse creditApplicationDashboard = creditApplicationService.getDashboard(branchId);
        if (creditApplicationDashboard == null) {
            throw new RuntimeException (
                "Credit application dashboard not found with branch id: " + branchId);
        }
        return creditApplicationDashboard;
    }
}