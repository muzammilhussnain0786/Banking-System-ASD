package edu.mum.cs.cs525.project.ccard.model.factorymethod;

import edu.mum.cs.cs525.project.ccard.model.CreditAccount;

public abstract class CreditAccountFactory {
    public abstract CreditAccount createAccount(String id);
}