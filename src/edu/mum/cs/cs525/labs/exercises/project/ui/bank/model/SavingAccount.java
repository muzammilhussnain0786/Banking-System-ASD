package edu.mum.cs.cs525.labs.exercises.project.ui.bank.model;

public class SavingAccount extends BankingAccount {

    private Double interest = 0.0325;

    public SavingAccount(Long accountNumber) {
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
        return SAVING_TYPE;
    }
}
