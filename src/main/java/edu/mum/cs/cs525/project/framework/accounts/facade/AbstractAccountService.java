package edu.mum.cs.cs525.project.framework.accounts.facade;


import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.factory.AccountDAO;
import edu.mum.cs.cs525.project.framework.accounts.factory.DatabaseAccountDAO;
import edu.mum.cs.cs525.project.framework.observer.Observable;
import edu.mum.cs.cs525.project.framework.observer.Observer;
import edu.mum.cs.cs525.project.framework.proxy.LoggingInvocationHandler;
import edu.mum.cs.cs525.project.framework.proxy.ProtectionInvocationHandler;
import edu.mum.cs.cs525.project.framework.proxy.ProxyFactory;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
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
		account.deposit(amount);
		proxyFactory.saveAccount(account);
		proxyFactory.updateAccount(account);
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
		proxyFactory.saveAccount(account);
		proxyFactory.updateAccount(account);
		this.notifyObservers(account);
	}



	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
		Account fromAccount = proxyFactory.loadAccount(fromAccountNumber);
		Account toAccount = proxyFactory.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		proxyFactory.updateAccount(fromAccount);
		proxyFactory.updateAccount(toAccount);
	}

	@Override
	public void executeBalanceBehaviour(String description) {
		Collection<Account> accounts = accountDAO.getAccounts();
		accounts.forEach(account -> {
			account.executeBalanceBehaviour(description);
			proxyFactory.updateAccount(account);
			this.notifyObservers(account);
		});
	}


}
