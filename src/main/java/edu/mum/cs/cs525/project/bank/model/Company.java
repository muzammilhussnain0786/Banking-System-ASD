package edu.mum.cs.cs525.project.bank.model;

import edu.mum.cs.cs525.project.bank.rules.CompanyEmailRule;
import edu.mum.cs.cs525.project.framework.accounts.AccountEntryInfo;
import edu.mum.cs.cs525.project.framework.accounts.IRule;
import edu.mum.cs.cs525.project.framework.accounts.Owner;

import java.util.List;

public class Company extends Owner {
    private int noOfEmployee;

    public Company(String name) {
        super(name);
    }

    public Company(String name, String city, String email, String state, String zip, int noOfEmployee) {
        super(name, city, email, state, zip);
        this.noOfEmployee = noOfEmployee;
    }

    public int getNoOfEmployee() {
        return noOfEmployee;
    }

    public void setNoOfEmployee(int noOfEmployee) {
        this.noOfEmployee = noOfEmployee;
    }

    @Override
    public List<IRule> getTheRules(AccountEntryInfo accountEntryInfo) {
        List<IRule> rules = super.getTheRules(accountEntryInfo);
        rules.add(new CompanyEmailRule(accountEntryInfo.getEntry()));
        return rules;
    }
}
