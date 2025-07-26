package com.danielnaiff.loans.services;

import com.danielnaiff.loans.Entities.Customer;
import com.danielnaiff.loans.Entities.Loan;
import com.danielnaiff.loans.Entities.dtos.CustomerLoansResponseDTO;
import com.danielnaiff.loans.Entities.dtos.CustomerResquestDTO;
import com.danielnaiff.loans.Entities.enums.LoanType;
import com.danielnaiff.loans.exceptions.LoanEligibilityException;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    public CustomerLoansResponseDTO checkAvailability(CustomerResquestDTO request) {
        Customer customer = new Customer();
        customer.setName(request.name());

        double income = request.income();
        int age = request.age();
        String location = request.location();

        boolean isYoungInSP = age < 30 && "SP".equalsIgnoreCase(location);
        boolean lowIncome = income <= 3000;
        boolean midIncome = income > 3000 && income <= 5000;
        boolean highIncome = income >= 5000;

        // PERSONAL
        if (lowIncome || (midIncome && isYoungInSP)) {
            customer.addLoan(new Loan(LoanType.PERSONAL));
        }

        // GUARANTEED
        if (lowIncome || (midIncome && isYoungInSP)) {
            customer.addLoan(new Loan(LoanType.GUARANTEED));
        }

        // CONSIGNMENT
        if (highIncome) {
            customer.addLoan(new Loan(LoanType.CONSIGNMENT));
        }

        if (customer.getLoanTypes().isEmpty()) {
            throw new LoanEligibilityException("Nenhum empréstimo disponível para esse perfil.");
        }

        return new CustomerLoansResponseDTO(customer.getName(), customer.getLoanTypes());
    }
}
