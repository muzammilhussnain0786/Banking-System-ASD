package edu.mum.cs.cs525.project.framework.accounts.facade;


import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.AccountEntry;
import edu.mum.cs.cs525.project.framework.accounts.AccountEntryInfo;
import edu.mum.cs.cs525.project.framework.accounts.factory.AccountDAO;
import edu.mum.cs.cs525.project.framework.accounts.factory.DatabaseAccountDAO;
import edu.mum.cs.cs525.project.framework.observer.Observable;
import edu.mum.cs.cs525.project.framework.observer.Observer;
import edu.mum.cs.cs525.project.framework.proxy.LoggingInvocationHandler;
import edu.mum.cs.cs525.project.framework.proxy.ProxyFactory;
import edu.mum.cs.cs525.project.framework.proxy.WithdrawInvocationHandler;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public abstract class AbstractAccountService implements IAccountService, Observable {

	AccountDAO accountDAO;
	
	private final List<Observer> observers = new ArrayList<>();
	
	AccountDAO proxyFactory = (AccountDAO)ProxyFactory.newInstance(new DatabaseAccountDAO());
	
	public AbstractAccountService(){
		accountDAO = createAccountDAO();
	}

	protected abstract AccountDAO createAccountDAO();

	public Account createAccount(Account account) {

		AccountDAO  proxy = (AccountDAO ) Proxy.newProxyInstance(AccountDAO.class.getClassLoader(),
    			new Class[] {AccountDAO.class }, new LoggingInvocationHandler(accountDAO));
	    proxy.saveAccount(account);
		this.notifyObservers(account);
		return account;
	}

	public void deposit(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);

		AccountEntry entry = account.deposit(amount);
		proxyFactory.updateAccount(account);
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

		AccountDAO  proxy = (AccountDAO ) Proxy.newProxyInstance(AccountDAO.class.getClassLoader(),
    			new Class[] {AccountDAO.class }, new WithdrawInvocationHandler(accountDAO));
        proxy.updateAccount(account);

		this.notifyObservers(account);
		this.notifyObservers(new AccountEntryInfo(account, entry));
	}

	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
		Account fromAccount = proxyFactory.loadAccount(fromAccountNumber);
		Account toAccount = proxyFactory.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
	}

	public void refreshDb() {
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
	public String generateReports() {
		Collection<Account> accounts = accountDAO.getAccounts();
		StringBuilder report = new StringBuilder();
		accounts.forEach(account -> {
			report.append(account.toString()).append("\n");
		});
		return report.toString();
	}
}
