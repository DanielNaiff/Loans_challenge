package com.danielnaiff.loans.Entities;

import com.danielnaiff.loans.Entities.enums.LoanType;

public class Loan {
    private LoanType type;
    private int interest_rate;

    public Loan() {
    }

    public Loan(LoanType type, int interest_rate) {
        this.type = type;
        this.interest_rate = interest_rate;
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
}
