package edu.mum.cs.cs525.project.framework.accounts.factory;


import edu.mum.cs.cs525.project.framework.accounts.Account;

import java.util.Collection;
import java.util.List;

public interface AccountDAO {
	void saveAccount(Account account);
	void saveAccount(List<Account> account);
	void updateAccount(Account account);
	Account loadAccount(String accountnumber);
	Collection<Account> getAccounts();
}
