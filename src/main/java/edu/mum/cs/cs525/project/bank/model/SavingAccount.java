package edu.mum.cs.cs525.project.bank.model;

import edu.mum.cs.cs525.project.framework.accounts.strategy.BalanceBehaviour;

public class SavingAccount extends BankingAccount {

    private Double interest = 0.0325;


    public SavingAccount(String accountNumber, BalanceBehaviour balanceBehaviour) {
        super(accountNumber, balanceBehaviour);
    }
}
