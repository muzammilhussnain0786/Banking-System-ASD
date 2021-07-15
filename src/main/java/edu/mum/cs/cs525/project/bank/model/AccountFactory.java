package edu.mum.cs.cs525.project.bank.model;

import edu.mum.cs.cs525.project.bank.strategy.CheckingAccountInterestBehaviour;
import edu.mum.cs.cs525.project.bank.strategy.SavingAccountInterestBehaviour;
import edu.mum.cs.cs525.project.framework.accounts.Account;

public class AccountFactory {
    public Account getAccount(String accountType, String accountNumber){
        return switch (accountType) {
            case "Ch" -> new CheckingAccount(accountNumber, new CheckingAccountInterestBehaviour());
            case "S" -> new SavingAccount(accountNumber, new SavingAccountInterestBehaviour());
            default -> throw new IllegalArgumentException("Account is not supported");
        };
    }
}
