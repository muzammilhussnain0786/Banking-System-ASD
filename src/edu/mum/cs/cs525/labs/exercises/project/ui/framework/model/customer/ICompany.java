package edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.customer;

public interface ICompany extends ICustomer {
	public default String getCustomerType() {
		return ICustomer.COMPANY;
	}
}
