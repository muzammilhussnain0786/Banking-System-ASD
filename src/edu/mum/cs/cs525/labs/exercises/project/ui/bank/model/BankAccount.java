package edu.mum.cs.cs525.labs.exercises.project.ui.bank.model;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.Account;

import java.time.LocalDate;

public class BankAccount extends Account {
    public BankAccount(Long id, String createdBy, String changedBy, LocalDate createdDate, LocalDate changedDate, double currentBalance) {
        super(id, createdBy, changedBy, createdDate, changedDate, currentBalance);
    }
}
