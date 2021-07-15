package edu.mum.cs.cs525.project.bank.rules;

import edu.mum.cs.cs525.project.framework.accounts.AccountEntryInfo;
import edu.mum.cs.cs525.project.framework.accounts.IRule;
import edu.mum.cs.cs525.project.framework.accounts.Owner;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class EmailRulesProcessor {


    public static boolean processEmailRules(Owner owner, AccountEntryInfo accountEntryInfo) {
        List<IRule> rules = owner.getTheRules(accountEntryInfo);
        rules = rules.stream().filter(iRule -> iRule.getRuleType().equals("email")).collect(Collectors.toList());
        AtomicBoolean result = new AtomicBoolean(true);
        rules.forEach(rule->{
            rule.execute();
            result.set(result.get() && rule.isMatch());
        });
        return result.get();
    }
}
