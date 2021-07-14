package edu.mum.cs.cs525.project.framework.accounts.facade;


import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.factory.AccountDAO;
import edu.mum.cs.cs525.project.framework.observer.Observable;
import edu.mum.cs.cs525.project.framework.observer.Observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public abstract class AbstractAccountService implements IAccountService, Observable {

	AccountDAO accountDAO;
	private final List<Observer> observers = new ArrayList<>();
	
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
		account.deposit(amount);
		accountDAO.updateAccount(account);
		this.notifyObservers(account);
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
		account.withdraw(amount);
		accountDAO.updateAccount(account);
	}



	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
	}

	@Override
	public void executeBalanceBehaviour(String description) {
		Collection<Account> accounts = accountDAO.getAccounts();
		accounts.forEach(account -> account.executeBalanceBehaviour(description));
	}

	@Override
	public void generateReports() {

	}
}
