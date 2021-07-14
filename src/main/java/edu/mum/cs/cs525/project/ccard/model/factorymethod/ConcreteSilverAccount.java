package edu.mum.cs.cs525.project.ccard.model.factorymethod;

import edu.mum.cs.cs525.project.ccard.model.CreditAccount;
import edu.mum.cs.cs525.project.ccard.model.SilverAccount;

public class ConcreteSilverAccount extends CreditAccountFactory {
    @Override
    public CreditAccount createAccount(String id) {
        return new SilverAccount(id);
    }
}
