package edu.mum.cs.cs525.project.bank.model;

import edu.mum.cs.cs525.project.framework.accounts.Owner;

public class PersonalCustomer extends Owner {
    private String birthDate;

    public PersonalCustomer(String name, String city, String email, String state, String zip, String birthDate) {
        super(name, city, email, state, zip);
        this.birthDate = birthDate;
    }
}
