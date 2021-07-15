package edu.mum.cs.cs525.project.framework.accounts.facade;


import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.AccountEntry;
import edu.mum.cs.cs525.project.framework.accounts.AccountEntryInfo;
import edu.mum.cs.cs525.project.framework.accounts.factory.AccountDAO;
import edu.mum.cs.cs525.project.framework.observer.Observable;
import edu.mum.cs.cs525.project.framework.observer.Observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public abstract class AbstractAccountService implements IAccountService, Observable {

	AccountDAO accountDAO;

	public AbstractAccountService(){
		accountDAO = createAccountDAO();
	}

	protected abstract AccountDAO createAccountDAO();

	public Account createAccount(Account account) {

		accountDAO.saveAccount(account);
		this.notifyObservers(account);
		return account;
	}

	public void deposit(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		AccountEntry entry = account.deposit(amount);
		accountDAO.updateAccount(account);
		this.notifyObservers(account);
		AccountEntryInfo data = new AccountEntryInfo(account, entry);
		this.notifyObservers(data);
	}

	public Account getAccount(String accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		AccountEntry entry = account.withdraw(amount);
		accountDAO.updateAccount(account);
		this.notifyObservers(account);
		this.notifyObservers(new AccountEntryInfo(account, entry));
	}

	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
	}

	public void refresDb() {
		accountDAO.saveAccount(Collections.emptyList());
	}

	@Override
	public void executeBalanceBehaviour(String description) {
		Collection<Account> accounts = accountDAO.getAccounts();
		accounts.forEach(account -> {
			account.executeBalanceBehaviour(description);
			accountDAO.updateAccount(account);
			this.notifyObservers(account);
		});
	}

	@Override
	public Collection<Account> generateReports() {
		return accountDAO.getAccounts();
	}
}
