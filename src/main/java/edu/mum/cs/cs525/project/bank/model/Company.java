package edu.mum.cs.cs525.project.bank.model;

import edu.mum.cs.cs525.project.framework.accounts.Owner;

public class Company extends Owner {
    private int noOfEmployee;

    public Company(String name) {
        super(name);
    }

    public int getNoOfEmployee() {
        return noOfEmployee;
    }

    public void setNoOfEmployee(int noOfEmployee) {
        this.noOfEmployee = noOfEmployee;
    }
}
