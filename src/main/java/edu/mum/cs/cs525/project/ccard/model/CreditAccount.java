package edu.mum.cs.cs525.project.ccard.model;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.account.Account;

public abstract class CreditAccount extends Account {
    public static final String GOLD  = "Gold";
    public static final String SILVER = "Silver";
    public static final String BRONZE = "Bronze";

    private String creditAccountNumber;

    @Override
    public String getId() {
        return creditAccountNumber;
    }

    @Override
    public void setId(String creditAccountNumber) {
        this.creditAccountNumber = creditAccountNumber;
        super.setId(creditAccountNumber);
    }

    public void setCreditAccountNumber(String creditAccountNumber) {
        setId(creditAccountNumber);
    }
}
