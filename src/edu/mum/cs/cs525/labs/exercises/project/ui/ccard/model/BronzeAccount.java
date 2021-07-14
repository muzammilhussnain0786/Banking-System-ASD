package edu.mum.cs.cs525.labs.exercises.project.ui.ccard.model;

public class BronzeAccount extends CreditAccount {

    private Double interest = 0.20;
    private Double minimumPayment = 0.22;

    public BronzeAccount(Long accountNUmber) {
        setId(accountNUmber);
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
        return BRONZE;
    }

    @Override
    public double getMP() {
        return minimumPayment;
    }
}
