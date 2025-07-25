package com.danielnaiff.loans.Entities;

import com.danielnaiff.loans.Entities.enums.LoanType;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int age;
    private String cpf;
    private String name;
    private Double income;
    private String location;
    private List<Loan> loans = new ArrayList<>();

    public Customer() {
    }

    public Customer(int age, String cpf, String name, Double income, String location, List<Loan> loans) {
        this.age = age;
        this.cpf = cpf;
        this.name = name;
        this.income = income;
        this.location = location;
        this.loans = loans;
    }

    public List<Loan> getLoanTypes() {
        return loans;
    }

    public void addLoan(Loan loans) {
        this.loans.add(loans);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
