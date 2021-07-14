package edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.customer;

import java.util.ArrayList;
import java.util.List;

public class Company extends Customer implements ICompany {
//	private Integer numberOfEmployees;
	private List<Person> employees;

	public Company() {
		this.employees = new ArrayList<>();
	}
	public Company(List<Person> employees) {
		this.employees = employees;
	}

	public List<Person> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Person> employees) {
		this.employees = employees;
	}
}
