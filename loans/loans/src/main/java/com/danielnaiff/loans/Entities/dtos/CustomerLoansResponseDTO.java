package com.danielnaiff.loans.Entities.dtos;

import com.danielnaiff.loans.Entities.Loan;

import java.util.List;

public record CustomerLoansResponseDTO(String name, List<Loan> loans) {
}
