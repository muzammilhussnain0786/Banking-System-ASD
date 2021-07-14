package edu.mum.cs.cs525.project.bank.observer;


import edu.mum.cs.cs525.project.framework.accounts.Account;

public class EmailSender implements Observer{

    @Override
    public void accountCreated(Account account) {
        System.out.println(EmailSender.class.getSimpleName() + " : " + account.getAccountNumber() + " account created");
    }
}
