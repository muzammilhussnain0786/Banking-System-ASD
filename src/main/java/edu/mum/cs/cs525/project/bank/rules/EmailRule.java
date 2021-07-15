package edu.mum.cs.cs525.project.bank.rules;

import edu.mum.cs.cs525.project.bank.model.CheckingAccount;
import edu.mum.cs.cs525.project.bank.model.SavingAccount;
import edu.mum.cs.cs525.project.framework.accounts.Account;

public class EmailRule implements IRule {

    boolean isMatch;
    Account account;

    public EmailRule(CheckingAccount account) {
        this.account = account;
    }

    public EmailRule(SavingAccount account) {
        this.account = account;
    }

    @Override
    public void execute() {


    }

    @Override
    public boolean isMatch() {
        return isMatch;
    }
}
