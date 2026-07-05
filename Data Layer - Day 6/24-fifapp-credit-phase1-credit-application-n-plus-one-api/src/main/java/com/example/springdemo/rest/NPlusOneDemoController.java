package com.example.springdemo.rest;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.dto.CreditApplicationResponse;
import com.example.springdemo.service.CreditApplicationService;

@RestController
@RequestMapping("/api/demo")
public class NPlusOneDemoController {
    private final CreditApplicationService creditApplicationService;
    public NPlusOneDemoController(CreditApplicationService creditApplicationService) {
        this.creditApplicationService = creditApplicationService;
    }

    @GetMapping("/n-plus-one/credit-applications") 
    public List<CreditApplicationResponse> getCreditApplications() {
        return creditApplicationService.getAllCreditApplications(null);
    }
}
