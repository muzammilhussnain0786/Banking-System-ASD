package edu.mum.cs.cs525.project.framework.model;

import java.time.LocalDate;

public class Account extends BaseEntity{
    private double currentBalance;

    public Account(Long id, String createdBy, String changedBy, LocalDate createdDate, LocalDate changedDate, double currentBalance) {
        super(id, createdBy, changedBy, createdDate, changedDate);
        this.currentBalance = currentBalance;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
}
