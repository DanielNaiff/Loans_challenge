package com.danielnaiff.loans.Entities.dtos;

import java.math.BigDecimal;

public record PersonResquestDTO(int age, String cpf, String name, BigDecimal income, String location) {
}
