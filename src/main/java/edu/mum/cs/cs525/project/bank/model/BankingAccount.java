package edu.mum.cs.cs525.project.bank.model;


import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.strategy.BalanceBehaviour;

public class BankingAccount extends Account {
    public static final String SAVING_TYPE  = "Saving";
    public static final String CHECKING_TYPE = "Checking";

    private String accountNumber;

    public BankingAccount(String accountNumber, BalanceBehaviour balanceBehaviour) {
        super(accountNumber, balanceBehaviour);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
    }

}
