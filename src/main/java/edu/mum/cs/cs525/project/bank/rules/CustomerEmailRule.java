package edu.mum.cs.cs525.project.bank.rules;

import edu.mum.cs.cs525.project.framework.accounts.AccountEntry;

public class CustomerEmailRule extends IEmailRule {

    boolean isMatch;
    AccountEntry accountEntry;

    public CustomerEmailRule(AccountEntry accountEntry) {
        this.accountEntry = accountEntry;
    }

    @Override
    public void execute() {
        isMatch = accountEntry.getAmount() > 400;
    }

    @Override
    public boolean isMatch() {
        return isMatch;
    }
}
