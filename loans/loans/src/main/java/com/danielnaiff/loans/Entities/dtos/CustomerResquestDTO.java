package com.danielnaiff.loans.Entities.dtos;

import java.math.BigDecimal;

public record CustomerResquestDTO(int age, String cpf, String name, Double income, String location) {
}
