package edu.mum.cs.cs525.project.framework.accounts;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Owner implements Serializable {
	@Serial
	private static final long serialVersionUID = -2722777601622496163L;

	private String id;
	private String name;
	private String city;
	private String email;
	private String state;
	private String zip;

	private List<Account> accounts = new ArrayList<>();

	public Owner(String name) {
		this.name = name;
	}

	public Owner(String name, String city, String email, String state, String zip) {
		this.name = name;
		this.city = city;
		this.email = email;
		this.state = state;
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
