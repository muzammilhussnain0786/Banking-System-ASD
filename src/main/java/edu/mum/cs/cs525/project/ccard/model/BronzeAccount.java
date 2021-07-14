package edu.mum.cs.cs525.project.ccard.model;

public class BronzeAccount extends CreditAccount {

    private Double interest = 0.20;
    private Double minimumPayment = 0.22;

    public BronzeAccount(String accountNUmber) {
        setId(accountNUmber);
    }


}
