package edu.mum.cs.cs525.project.bank.rules;

import edu.mum.cs.cs525.project.framework.accounts.AccountEntry;

public class CompanyEmailRule extends IEmailRule {

    boolean isMatch;
    AccountEntry entry;

    public CompanyEmailRule(AccountEntry entry) {
        this.entry = entry;
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isMatch() {
        return isMatch;
    }
}
