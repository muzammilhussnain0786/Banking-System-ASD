package edu.mum.cs.cs525.project.framework.accounts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Owner implements Serializable {
	private String id;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void addAccount(Account account){
		accounts.add(account);

	}
}
