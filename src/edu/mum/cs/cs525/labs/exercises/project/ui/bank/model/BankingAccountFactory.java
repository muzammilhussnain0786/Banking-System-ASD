package edu.mum.cs.cs525.labs.exercises.project.ui.bank.model;

public abstract class BankingAccountFactory {
    public static BankingAccount createAccount(String accountType, Long id) {
        if (accountType.equals(BankingAccount.CHECKING_TYPE))
            return new CheckingAccount(id);
        else if (accountType.equals(BankingAccount.SAVING_TYPE))
            return new SavingAccount(id);
        else
            return null;
    }
}