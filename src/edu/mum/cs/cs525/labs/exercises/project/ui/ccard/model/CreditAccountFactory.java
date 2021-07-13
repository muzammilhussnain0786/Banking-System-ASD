package edu.mum.cs.cs525.labs.exercises.project.ui.ccard.model;

import edu.mum.cs.cs525.labs.exercises.project.ui.bank.model.CheckingAccount;
public abstract class CreditAccountFactory {
    public static CreditAccount createAccount(String accountType, Long id) {
        if (accountType.equals(CreditAccount.GOLD))
            return new GoldAccount(id);
        else if (accountType.equals(CreditAccount.SILIVER))
            return new SilverAccount(id);
        else if (accountType.equals(CreditAccount.BRONZE))
            return new BronzeAccount(id);
        else
            return null;
    }
}