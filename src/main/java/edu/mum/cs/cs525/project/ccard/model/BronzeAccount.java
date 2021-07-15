package edu.mum.cs.cs525.project.ccard.model;

import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.strategy.BalanceBehaviour;

public class BronzeAccount extends Account {

    private Double interest = 0.1;

    public BronzeAccount(String accountNumber, BalanceBehaviour balanceBehaviour) {
        super(accountNumber, balanceBehaviour);
    }

    public String getAccountType(){
        return "Bronze";
    }

    @Override
    public Object[] row() {
        return new String[]{this.getAccountNumber(), this.getOwner().getName(), this.getExpDate(), this.getAccountType(),  String.valueOf(this.getBalance())};
    }

    @Override
    public String toString() {
        return "BronzeAccount{" +
                "interest=" + interest +
                '}';
    }
}
