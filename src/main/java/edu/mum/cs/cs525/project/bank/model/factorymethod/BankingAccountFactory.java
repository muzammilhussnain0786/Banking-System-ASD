package edu.mum.cs.cs525.project.bank.model.factorymethod;

import edu.mum.cs.cs525.project.bank.model.BankingAccount;

public abstract class BankingAccountFactory {
    public abstract BankingAccount createAccount(String id);
}