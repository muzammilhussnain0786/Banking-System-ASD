package edu.mum.cs.cs525.project.ccard.model;

import edu.mum.cs.cs525.project.bank.model.PersonalCustomer;
import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.strategy.BalanceBehaviour;

public class GoldAccount extends Account {

    private Double interest = 0.06;

    public GoldAccount(String accountNumber, BalanceBehaviour balanceBehaviour) {
        super(accountNumber, balanceBehaviour);
    }

    public String getAccountType(){
        return "Gold";
    }

    @Override
    public Object[] row() {
        return new String[]{this.getOwner().getName(), this.getAccountNumber(), this.getExpDate(), this.getAccountType(),  String.valueOf(this.getBalance())};
    }
}
