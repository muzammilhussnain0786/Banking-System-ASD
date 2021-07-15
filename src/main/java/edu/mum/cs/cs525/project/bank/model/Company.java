package edu.mum.cs.cs525.project.bank.model;

import edu.mum.cs.cs525.project.framework.accounts.Owner;

public class Company extends Owner {
    private int noOfEmployee;

    public Company(String name) {
        super(name);
    }

    public Company(String name, String city, String email, String state, String zip, int noOfEmployee) {
        super(name, city, email, state, zip);
        this.noOfEmployee = noOfEmployee;
    }

    public int getNoOfEmployee() {
        return noOfEmployee;
    }

    public void setNoOfEmployee(int noOfEmployee) {
        this.noOfEmployee = noOfEmployee;
    }
}
