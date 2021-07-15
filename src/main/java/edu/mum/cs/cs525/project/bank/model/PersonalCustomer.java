package edu.mum.cs.cs525.project.bank.model;

import edu.mum.cs.cs525.project.bank.rules.CustomerEmailRule;
import edu.mum.cs.cs525.project.framework.accounts.AccountEntryInfo;
import edu.mum.cs.cs525.project.framework.accounts.IRule;
import edu.mum.cs.cs525.project.framework.accounts.Owner;

import java.util.List;

public class PersonalCustomer extends Owner {
    private String birthDate;

    public PersonalCustomer(String name, String city, String email, String state, String zip, String birthDate) {
        super(name, city, email, state, zip);
        this.birthDate = birthDate;
    }

    @Override
    public List<IRule> getTheRules(AccountEntryInfo accountEntryInfo) {
        List<IRule> rules = super.getTheRules(accountEntryInfo);
        rules.add(new CustomerEmailRule(accountEntryInfo.getEntry()));
        return rules;
    }
}
