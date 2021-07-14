package edu.mum.cs.cs525.labs.exercises.project.ui.bank.model.factorymethod;

import edu.mum.cs.cs525.labs.exercises.project.ui.bank.model.BankingAccount;

public abstract class BankingAccountFactory {
    public abstract BankingAccount createAccount(String id);
}