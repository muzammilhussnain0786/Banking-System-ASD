package edu.mum.cs.cs525.labs.exercises.project.ui.framework.service;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.account.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.observer.Observer;

public class EmailSenderService implements Observer<Account> {
    @Override
    public void update(Account data) {
        //TODO think about the template for sending email
        System.out.println("Account " + data.getId() +" has new balance: " + data.getCurrentBalance());
    }
}
