package edu.mum.cs.cs525.project.bank.model;

import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.Owner;
import edu.mum.cs.cs525.project.framework.accounts.strategy.BalanceBehaviour;

public class CheckingAccount extends Account {

    private Double interest = 0.01;

    public CheckingAccount(String accountNumber, BalanceBehaviour balanceBehaviour) {
        super(accountNumber, balanceBehaviour);
    }

    @Override
    public Object[] row() {
        String ownerType = this.getOwner() instanceof PersonalCustomer? "P" : "C";
        return new String[]{this.getAccountNumber(), this.getOwner().getName(), this.getOwner().getCity(), ownerType, "Ch", String.valueOf(this.getBalance())};
    }
}
