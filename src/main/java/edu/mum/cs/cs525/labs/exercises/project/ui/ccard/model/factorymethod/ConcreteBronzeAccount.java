package edu.mum.cs.cs525.labs.exercises.project.ui.ccard.model.factorymethod;

import edu.mum.cs.cs525.labs.exercises.project.ui.ccard.model.BronzeAccount;
import edu.mum.cs.cs525.labs.exercises.project.ui.ccard.model.CreditAccount;

public class ConcreteBronzeAccount extends CreditAccountFactory {
    @Override
    public CreditAccount createAccount(String id) {
        return new BronzeAccount(id);
    }
}
