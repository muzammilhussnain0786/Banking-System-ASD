package edu.mum.cs.cs525.project.ccard.model;

public class SilverAccount extends CreditAccount {

    private Double interest = 0.18;
    private Double minimumPayment = 0.14;

    public SilverAccount(String accountNumber) {
        setId(accountNumber);
    }



}
