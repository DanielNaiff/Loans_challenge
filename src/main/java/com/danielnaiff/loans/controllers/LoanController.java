package com.danielnaiff.loans.controllers;

import com.danielnaiff.loans.Entities.dtos.CustomerLoansResponseDTO;
import com.danielnaiff.loans.Entities.dtos.CustomerResquestDTO;
import com.danielnaiff.loans.services.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/customer-loans")
    public ResponseEntity<CustomerLoansResponseDTO> customerLoans(@RequestBody @Valid CustomerResquestDTO customerResquestDTO){

         CustomerLoansResponseDTO response = loanService.checkAvailability(customerResquestDTO);

        return ResponseEntity.ok(response);
    }
}
