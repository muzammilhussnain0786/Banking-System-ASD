package edu.mum.cs.cs525.labs.exercises.project.ui.ccard.model.factorymethod;

import edu.mum.cs.cs525.labs.exercises.project.ui.ccard.model.CreditAccount;
import edu.mum.cs.cs525.labs.exercises.project.ui.ccard.model.SilverAccount;

public class ConcreteSilverAccount extends CreditAccountFactory {
    @Override
    public CreditAccount createAccount(Long id) {
        return new SilverAccount(id);
    }
}
