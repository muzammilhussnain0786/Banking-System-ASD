package edu.mum.cs.cs525.project.ccard.model;

import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.strategy.BalanceBehaviour;

public class SilverAccount extends Account {

    private Double interest = 0.08;

    public SilverAccount(String accountNumber, BalanceBehaviour balanceBehaviour) {
        super(accountNumber, balanceBehaviour);
    }

    public String getAccountType(){
        return "Silver";
    }

    @Override
    public Object[] row() {
        return new String[]{this.getOwner().getName(), this.getAccountNumber(), this.getExpDate(), this.getAccountType(),  String.valueOf(this.getBalance())};
    }

    @Override
    public String toString() {
        return "SilverAccount{" +
                "interest=" + interest +
                '}';
    }
}
