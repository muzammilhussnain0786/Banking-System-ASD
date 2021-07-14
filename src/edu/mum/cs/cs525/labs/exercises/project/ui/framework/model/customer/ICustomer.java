package edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.customer;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.account.IAccount;

public interface ICustomer {
	public static final String COMPANY = "Company";
	public static final String PERSON = "Person";
	void addAccount(IAccount account);
	void removeAccount(IAccount account);
	void emailCustomer();
	String getCustomerType();
}
