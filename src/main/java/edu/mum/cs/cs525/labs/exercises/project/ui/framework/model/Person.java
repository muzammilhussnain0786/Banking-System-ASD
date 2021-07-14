package edu.mum.cs.cs525.labs.exercises.project.ui.framework.model;

import java.time.LocalDate;

public class Person extends Customer{
    private LocalDate birthDate;
    private Company company;

    // Default constructor
    public Person() {
        super();
    }

    public Person(String name, String street, String city, String state, String zip, String email, LocalDate birthDate) {
        super(name, street, city, state, zip, email);
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
}
