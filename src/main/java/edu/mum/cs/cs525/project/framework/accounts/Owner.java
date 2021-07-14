package edu.mum.cs.cs525.project.framework.accounts;

import java.util.ArrayList;
import java.util.List;

public class Owner {
	private String name;
	private List<Account> accounts = new ArrayList<>();

	public Owner(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addAccount(Account account){
		accounts.add(account);

	}
}
