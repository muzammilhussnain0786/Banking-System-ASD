package edu.mum.cs.cs525.labs.exercises.project.ui.bank.model;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.account.Account;

public abstract class BankingAccount extends Account {
    public static final String SAVING_TYPE  = "Saving";
    public static final String CHECKING_TYPE = "Checking";

    private String accountNumber;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        setId(accountNumber);
    }

    @Override
    public void setId(String accountNumber) {
        this.accountNumber = accountNumber;
        super.setId(accountNumber);
    }



}
