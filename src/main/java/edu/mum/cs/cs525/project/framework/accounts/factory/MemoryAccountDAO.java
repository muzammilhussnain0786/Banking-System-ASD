package edu.mum.cs.cs525.project.framework.accounts.factory;


import edu.mum.cs.cs525.project.framework.accounts.Account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MemoryAccountDAO implements AccountDAO {
	Collection<Account> accountlist = new ArrayList<Account>();

	public void updateAccount(Account account) {
		Account accountexist = loadAccount(account.getAccountNumber());
		if (accountexist != null) {
			accountlist.remove(accountexist); // remove the old
			accountlist.add(account); // add the new
		}

	}

	@Override
	public void saveAccount(Account account) {
		accountlist.add(account); // add the new
	}

	@Override
	public void saveAccount(List<Account> accounts) {
		accountlist.addAll(accounts);
	}

	public Account loadAccount(String accountNumber) {
		for (Account account : accountlist) {
			if (account.getAccountNumber().equals(accountNumber)) {
				return account;
			}
		}
		return null;
	}

	public Collection<Account> getAccounts() {
		return accountlist;
	}

}
