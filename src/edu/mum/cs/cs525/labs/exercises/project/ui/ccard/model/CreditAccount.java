package edu.mum.cs.cs525.labs.exercises.project.ui.ccard.model;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.account.Account;

public abstract class CreditAccount extends Account {
    public static final String GOLD  = "Gold";
    public static final String SILVER = "Silver";
    public static final String BRONZE = "Bronze";

    private Long creditAccountNumber;

    @Override
    public Long getId() {
        return creditAccountNumber;
    }

    @Override
    public void setId(Long creditAccountNumber) {
        this.creditAccountNumber = creditAccountNumber;
        super.setId(creditAccountNumber);
    }

    public void setCreditAccountNumber(Long creditAccountNumber) {
        setId(creditAccountNumber);
    }
}
