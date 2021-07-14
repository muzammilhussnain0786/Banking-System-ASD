package edu.mum.cs.cs525.labs.exercises.project.ui.bank.model;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.account.Account;

public abstract class BankingAccount extends Account {
    public static final String SAVING_TYPE  = "Saving";
    public static final String CHECKING_TYPE = "Checking";

    private Long accountNumber;

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        setId(accountNumber);
    }

    @Override
    public void setId(Long accountNumber) {
        this.accountNumber = accountNumber;
        super.setId(accountNumber);
    }



}
