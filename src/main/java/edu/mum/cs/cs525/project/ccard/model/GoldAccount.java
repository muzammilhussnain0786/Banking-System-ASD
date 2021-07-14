package edu.mum.cs.cs525.project.ccard.model;

public class GoldAccount extends CreditAccount {

    private Double interest = 0.14;
    private Double minimumPayment = 0.12;

    public GoldAccount(String accountNumber) {
        setId(accountNumber);
    }


    public void addInterest() {

    }


}
