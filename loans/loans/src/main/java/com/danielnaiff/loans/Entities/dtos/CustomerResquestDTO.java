package com.danielnaiff.loans.Entities.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record CustomerResquestDTO(

        @NotBlank(message = "Name is mandatory")
        String name,

        @NotNull(message = "Income is mandatory")
        @DecimalMin(value = "0.0", inclusive = false, message = "Income must be positive")
        Double income,

        @Min(value = 18, message =  "Not a valid age value")
        int age,

        @NotBlank(message = "CPF is mandatory")
        String cpf,





        @NotBlank(message = "Location is mandatory")
        String location
) {
}
