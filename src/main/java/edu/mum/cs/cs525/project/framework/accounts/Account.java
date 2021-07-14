package edu.mum.cs.cs525.project.framework.accounts;


import edu.mum.cs.cs525.project.framework.accounts.strategy.BalanceBehaviour;
import edu.mum.cs.cs525.project.framework.accounts.strategy.EmptyBalanceBehaviour;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Account implements Serializable {
	private Owner owner;

	private String accountNumber;

	private List<AccountEntry> entryList = new ArrayList<AccountEntry>();

	transient BalanceBehaviour balanceBehaviour;

	public Account(String accountNumber, BalanceBehaviour balanceBehaviour) {
		this.accountNumber = accountNumber;
		this.balanceBehaviour = balanceBehaviour;
	}

	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
		this.balanceBehaviour = new EmptyBalanceBehaviour();
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		double balance = 0;
		for (AccountEntry entry : entryList) {
			balance += entry.getAmount();
		}
		return balance;
	}

	public void deposit(double amount) {
		AccountEntry entry = new AccountEntry(amount, "deposit", "", "");
		addEntry(entry);
	}

	public void withdraw(double amount) {
		AccountEntry entry = new AccountEntry(-amount, "withdraw", "", "");
		addEntry(entry);
	}

	private void addEntry(AccountEntry entry) {
		entryList.add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description) {
		AccountEntry fromEntry = new AccountEntry(-amount, description, toAccount.getAccountNumber(),
				toAccount.getOwner().getName());
		AccountEntry toEntry = new AccountEntry(amount, description, toAccount.getAccountNumber(),
				toAccount.getOwner().getName());

		addEntry(fromEntry);
		
		toAccount.addEntry(toEntry);
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Collection<AccountEntry> getEntryList() {
		return entryList;
	}

	public void executeBalanceBehaviour(String description){
		AccountEntry entry = new AccountEntry(balanceBehaviour.getResult(getBalance()), description, "", "");
		addEntry(entry);
	}

	public BalanceBehaviour getBalanceBehaviour() {
		return balanceBehaviour;
	}

	public void setBalanceBehaviour(BalanceBehaviour balanceBehaviour) {
		this.balanceBehaviour = balanceBehaviour;
	}
}
