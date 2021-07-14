package edu.mum.cs.cs525.project.framework.service;


import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.observer.Observer;

public class EmailSenderService implements Observer<Account> {
    @Override
    public void update(Account data) {
        //TODO think about the template for sending email
        System.out.println("Account " + data.getAccountNumber() +" has new balance: " + data.getBalance());
    }
}
