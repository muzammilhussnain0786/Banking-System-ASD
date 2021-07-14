package edu.mum.cs.cs525.labs.exercises.project.ui.bank.model;

public class CheckingAccount extends BankingAccount {

    private Double interest = 0.01;

    public CheckingAccount(String accountNumber) {
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
        return CHECKING_TYPE;
    }
}
