package edu.mum.cs.cs525.labs.exercises.project.ui.ccard.model.factorymethod;

import edu.mum.cs.cs525.labs.exercises.project.ui.ccard.model.CreditAccount;
import edu.mum.cs.cs525.labs.exercises.project.ui.ccard.model.GoldAccount;

public class ConcreteGoldAccount extends CreditAccountFactory {
    @Override
    public CreditAccount createAccount(String id) {
        return new GoldAccount(id);
    }
}
