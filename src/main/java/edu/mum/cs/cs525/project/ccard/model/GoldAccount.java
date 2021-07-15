package edu.mum.cs.cs525.project.ccard.model;

import edu.mum.cs.cs525.project.framework.accounts.strategy.BalanceBehaviour;

public class GoldAccount extends CreditAccount {

    public GoldAccount(String accountNumber, BalanceBehaviour balanceBehaviour) {
        super(accountNumber, balanceBehaviour, 0.06);
    }

    public String getAccountType(){
        return "Gold";
    }

    @Override
    public Object[] row() {
        return new String[]{this.getAccountNumber(), this.getOwner().getName(), this.getExpDate(), this.getAccountType(),  String.valueOf(this.getBalance())};
    }

    @Override
    public String toString() {
        return "GoldAccount{" +
                "interest=" + interest +
                '}';
    }
}
