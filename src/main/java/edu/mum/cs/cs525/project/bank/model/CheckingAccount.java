package edu.mum.cs.cs525.project.bank.model;

import edu.mum.cs.cs525.project.framework.accounts.strategy.BalanceBehaviour;

public class CheckingAccount extends BankingAccount {

    private Double interest = 0.01;

    public CheckingAccount(String accountNumber, BalanceBehaviour balanceBehaviour) {
        super(accountNumber, balanceBehaviour);
    }
}
