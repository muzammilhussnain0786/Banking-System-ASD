package edu.mum.cs.cs525.project.bank.model.factorymethod;

import edu.mum.cs.cs525.project.bank.model.BankingAccount;
import edu.mum.cs.cs525.project.bank.model.SavingAccount;

public class ConcreteSavingAccount extends BankingAccountFactory {
    @Override
    public BankingAccount createAccount(String id) {
        return null;
    }
}
