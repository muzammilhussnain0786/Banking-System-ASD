package edu.mum.cs.cs525.project.bank.rules;

import edu.mum.cs.cs525.project.framework.accounts.AccountEntryInfo;
import edu.mum.cs.cs525.project.framework.accounts.Owner;

import java.util.List;

public class EmailRulesProcessor {


    public static boolean processEmailRules(Owner owner, AccountEntryInfo accountEntryInfo) {
        List<IEmailRule> rules = owner.getTheRules(accountEntryInfo);

        return false;
    }
}
