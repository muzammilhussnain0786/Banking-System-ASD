package edu.mum.cs.cs525.project.ccard.model;

import edu.mum.cs.cs525.project.framework.model.Account;

import java.time.LocalDate;

public class CreditCardAccount extends Account {
    public CreditCardAccount(Long id, String createdBy, String changedBy, LocalDate createdDate, LocalDate changedDate, double currentBalance) {
        super(id, createdBy, changedBy, createdDate, changedDate, currentBalance);
    }
}
