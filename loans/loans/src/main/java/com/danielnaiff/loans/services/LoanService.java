package com.danielnaiff.loans.services;

import com.danielnaiff.loans.Entities.Customer;
import com.danielnaiff.loans.Entities.Loan;
import com.danielnaiff.loans.Entities.dtos.CustomerLoansResponseDTO;
import com.danielnaiff.loans.Entities.dtos.CustomerResquestDTO;
import com.danielnaiff.loans.Entities.enums.LoanType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class LoanService {

    public LoanService(){}

    public CustomerLoansResponseDTO checkAvailability(CustomerResquestDTO customerRequest){
        
        Customer customer = new Customer();

        customer.setName(customerRequest.name());

        if(isEligibleForPersonalLoanByLowIncome(customerRequest.income())){
            customer.setLoanTypes(new Loan(LoanType.PERSONAL));
        }

        if(isEligibleForPersonalLoanByAgeAndLocation(customerRequest.income(), customerRequest.age())){
            customer.setLoanTypes(new Loan(LoanType.PERSONAL));
        }

        if(isEligibleForConsignmentLoanByHighIncome(customerRequest.income())){
            customer.setLoanTypes(new Loan(LoanType.CONSIGNMENT));
        }

        if(isEligibleForGuaranteedLoanByLowIncome(customerRequest.income())){
            customer.setLoanTypes(new Loan(LoanType.GUARANTEED));
        }

        if(isEligibleForGuaranteedLoanByAgeAndLocation(customerRequest.income(), customerRequest.age(),customerRequest.location())){
            customer.setLoanTypes(new Loan(LoanType.GUARANTEED));
        }

        return new CustomerLoansResponseDTO(customer.getName(), customer.getLoanTypes());
    }

    private boolean isEligibleForPersonalLoanByLowIncome(Double income) {
        return income <= 3000;
    }

    private boolean isEligibleForPersonalLoanByAgeAndLocation(Double income, int age) {
        return (income >= 3000 && income <= 5000) && age < 30;
    }

    private boolean isEligibleForConsignmentLoanByHighIncome(Double income) {
        return income >= 5000;
    }

    private boolean isEligibleForGuaranteedLoanByLowIncome(Double income) {
        return income <= 3000;
    }

    private boolean isEligibleForGuaranteedLoanByAgeAndLocation(Double income, int age, String state) {
        return (income <= 3000) && age < 30 && Objects.equals(state, "SP");
    }
}
