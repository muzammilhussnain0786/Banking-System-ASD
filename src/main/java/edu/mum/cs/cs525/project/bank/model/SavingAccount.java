package edu.mum.cs.cs525.project.bank.model;

import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.strategy.BalanceBehaviour;

public class SavingAccount extends Account {
    private Double interest = 0.0325;

    public SavingAccount(String accountNumber, BalanceBehaviour balanceBehaviour) {
        super(accountNumber, balanceBehaviour);
    }

    @Override
    public Object[] row() {
        String ownerType = this.getOwner() instanceof PersonalCustomer? "P" : "C";
        return new String[]{this.getAccountNumber(), this.getOwner().getName(), this.getOwner().getCity(), ownerType, "S", String.valueOf(this.getBalance())};
    }
}
