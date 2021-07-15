package edu.mum.cs.cs525.project.bank.rules;

import edu.mum.cs.cs525.project.framework.accounts.IRule;

public abstract class IEmailRule implements IRule {

    @Override
    public String getRuleType() {
        return "email";
    }
}
