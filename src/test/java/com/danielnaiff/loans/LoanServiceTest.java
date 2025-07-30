package com.danielnaiff.loans;

import com.danielnaiff.loans.Entities.Loan;
import com.danielnaiff.loans.Entities.dtos.CustomerLoansResponseDTO;
import com.danielnaiff.loans.Entities.enums.LoanType;
import com.danielnaiff.loans.Entities.dtos.CustomerResquestDTO;
import com.danielnaiff.loans.exceptions.LoanEligibilityException;
import com.danielnaiff.loans.services.LoanService;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LoanServiceTest {

    private final LoanService loanService = new LoanService();
    private final String TEST_CPF = "123.456.789-09";

    @Test
    void shouldGrantCorrectLoans_BasedOnIncomeAndProfile() {
        // Caso 1: Baixa renda - PERSONAL e GUARANTEED
        assertLoanTypes(2000.0, 40, "RJ",
                List.of(LoanType.PERSONAL, LoanType.GUARANTEED));

        // Caso 2: Média renda + jovem SP - PERSONAL e GUARANTEED
        assertLoanTypes(4000.0, 25, "SP",
                List.of(LoanType.PERSONAL, LoanType.GUARANTEED));

        // Caso 3: Alta renda - CONSIGNMENT
        assertLoanTypes(5000.0, 35, "MG",
                List.of(LoanType.CONSIGNMENT));
    }

    private void assertLoanTypes(double income, int age, String location, List<LoanType> expectedLoanTypes) {
        CustomerResquestDTO request = new CustomerResquestDTO(
                "Cliente Teste", income, age, TEST_CPF, location);

        CustomerLoansResponseDTO response = loanService.checkAvailability(request);

        List<LoanType> actualLoanTypes = response.loans().stream()
                .map(Loan::getType)
                .toList();

        assertAll(
                () -> assertEquals(expectedLoanTypes.size(), actualLoanTypes.size(),
                        "Número incorreto de empréstimos concedidos"),
                () -> assertTrue(actualLoanTypes.containsAll(expectedLoanTypes),
                        "Tipos de empréstimos incorretos. Esperados: " + expectedLoanTypes +
                                ", obtidos: " + actualLoanTypes)
        );
    }
}