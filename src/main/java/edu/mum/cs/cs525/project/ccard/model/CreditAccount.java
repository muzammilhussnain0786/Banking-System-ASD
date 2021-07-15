package edu.mum.cs.cs525.project.ccard.model;

import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.strategy.BalanceBehaviour;

public abstract class CreditAccount extends Account {

    Double interest;
    public CreditAccount(String accountNumber, BalanceBehaviour balanceBehaviour, Double interest) {
        super(accountNumber, balanceBehaviour);
        this.interest = interest;
    }

    public double getMI() {
        return super.getBalance()*interest;
    }
}
