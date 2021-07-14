package edu.mum.cs.cs525.labs.exercises.project.ui.bank.model.factorymethod;

import edu.mum.cs.cs525.labs.exercises.project.ui.bank.model.BankingAccount;
import edu.mum.cs.cs525.labs.exercises.project.ui.bank.model.CheckingAccount;

public class ConcreteCheckingAccount extends BankingAccountFactory {
    @Override
    public BankingAccount createAccount(String id) {
        return new CheckingAccount(id);
    }
}
