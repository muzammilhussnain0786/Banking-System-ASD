package edu.mum.cs.cs525.project.framework.accounts.factory;


import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.observer.Observable;

import java.util.Collection;
import java.util.Map;

public class DatabaseAccountDAO implements AccountDAO, Observable {
    DataAccess dataAccess = DataAccess.getInstance();

    @Override
    public void saveAccount(Account account) {
        dataAccess.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        Map<String, Account> stringAccountMap = dataAccess.readAccountMap();
        if (stringAccountMap.get(account.getAccountNumber()) == null){
            throw new IllegalArgumentException("Account not found");
        }
        dataAccess.saveAccount(account);
    }

    @Override
    public Account loadAccount(String accountnumber) {
        Map<String, Account> stringAccountMap = dataAccess.readAccountMap();
        Account account = stringAccountMap.get(accountnumber);
        if (account == null){
            throw new IllegalArgumentException("Account not found");
        }
        return account;
    }

    @Override
    public Collection<Account> getAccounts() {
        return dataAccess.readAccountMap().values();
    }
}
