package edu.mum.cs.cs525.project.bank.persistence;

import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.factory.AccountDAO;

import java.util.Collection;
import java.util.List;

public class MongoAccountDao implements AccountDAO {
    @Override
    public void saveAccount(Account account) {

    }

    @Override
    public void saveAccount(List<Account> account) {

    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public Account loadAccount(String accountnumber) {
        return null;
    }

    @Override
    public Collection<Account> getAccounts() {
        return null;
    }
}
