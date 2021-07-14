package edu.mum.cs.cs525.project.framework.accounts.factory;


import edu.mum.cs.cs525.project.framework.accounts.Account;

import java.util.Collection;

public interface AccountDAO {
	void saveAccount(Account account);
	void updateAccount(Account account);
	Account loadAccount(String accountnumber);
	Collection<Account> getAccounts();
}
