package edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.customer;

public interface IPerson extends ICustomer {
	public default String getCustomerType(){
		return ICustomer.PERSON;
	}
}
