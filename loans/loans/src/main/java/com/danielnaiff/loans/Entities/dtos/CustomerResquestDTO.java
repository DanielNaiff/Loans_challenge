package com.danielnaiff.loans.Entities.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CustomerResquestDTO(
        @NotBlank(message = "Age is mandatory")
        int age,

        @NotBlank(message = "CPF is mandatory")
        String cpf,

        @NotBlank(message = "Name is mandatory")
        String name,

        @NotNull(message = "Income is mandatory")
        @DecimalMin(value = "0.0", inclusive = false, message = "Income must be positive")
        Double income,

        @NotBlank(message = "Location is mandatory")
        String location
) {
}
