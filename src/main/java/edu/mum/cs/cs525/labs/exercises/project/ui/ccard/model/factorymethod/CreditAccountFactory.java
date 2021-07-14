package edu.mum.cs.cs525.labs.exercises.project.ui.ccard.model.factorymethod;

import edu.mum.cs.cs525.labs.exercises.project.ui.ccard.model.CreditAccount;

public abstract class CreditAccountFactory {
    public abstract CreditAccount createAccount(String id);
}