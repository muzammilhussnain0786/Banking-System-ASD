package edu.mum.cs.cs525.labs.exercises.project.ui.ccard.model;

public class SilverAccount extends CreditAccount {

    private Double interest = 0.18;
    private Double minimumPayment = 0.14;

    public SilverAccount(String accountNumber) {
        setId(accountNumber);
    }

    @Override
    public void addInterest() {
        Double newBalance = super.getCurrentBalance() + (super.getCurrentBalance() * interest);
        super.setCurrentBalance(newBalance);
    }

    @Override
    public double getInterest() {
        return interest;
    }

    @Override
    public String getAccountType() {
        return SILVER;
    }

    @Override
    public double getMp() {
        return minimumPayment;
    }
}
