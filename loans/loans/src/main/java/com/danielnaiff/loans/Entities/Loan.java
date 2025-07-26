package com.danielnaiff.loans.Entities;

import com.danielnaiff.loans.Entities.enums.LoanType;

import java.util.Objects;

public class Loan {
    private LoanType type;
    private int interest_rate;

    public Loan() {
    }

    public Loan(LoanType type) {
        this.type = type;
        this.interest_rate = switch (type) {
            case PERSONAL -> 4;
            case GUARANTEED -> 3;
            case CONSIGNMENT -> 2;
        };
    }

    public int getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(int interest_rate) {
        this.interest_rate = interest_rate;
    }

    public LoanType getType() {
        return type;
    }

    public void setType(LoanType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return type == loan.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "type=" + type +
                ", interest_rate=" + interest_rate +
                '}';
    }
}
