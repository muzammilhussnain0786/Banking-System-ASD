package edu.mum.cs.cs525.labs.exercises.project.ui.bank.model.factorymethod;

import edu.mum.cs.cs525.labs.exercises.project.ui.bank.model.BankingAccount;
import edu.mum.cs.cs525.labs.exercises.project.ui.bank.model.SavingAccount;

public class ConcreteSavingAccount extends BankingAccountFactory {
    @Override
    public BankingAccount createAccount(Long id) {
        return new SavingAccount(id);
    }
}
