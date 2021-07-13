package edu.mum.cs.cs525.project.bank.model;

import edu.mum.cs.cs525.project.framework.model.Account;

import java.time.LocalDate;

public class BankAccount extends Account {
    public BankAccount(Long id, String createdBy, String changedBy, LocalDate createdDate, LocalDate changedDate, double currentBalance) {
        super(id, createdBy, changedBy, createdDate, changedDate, currentBalance);
    }
}
