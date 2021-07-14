package edu.mum.cs.cs525.project.ccard.model;

public abstract class CreditAccountFactory {
    public static CreditAccount createAccount(String accountType, String id) {
        if (accountType.equals(CreditAccount.GOLD))
            return new GoldAccount(id);
        else if (accountType.equals(CreditAccount.SILVER))
            return new SilverAccount(id);
        else if (accountType.equals(CreditAccount.BRONZE))
            return new BronzeAccount(id);
        else
            return null;
    }
}