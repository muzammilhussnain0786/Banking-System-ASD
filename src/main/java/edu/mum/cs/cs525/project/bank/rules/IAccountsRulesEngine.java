package edu.mum.cs.cs525.project.bank.rules;

import edu.mum.cs.cs525.project.framework.accounts.Account;

public interface IAccountsRulesEngine {

    boolean processEmailRules(Account account);
}
