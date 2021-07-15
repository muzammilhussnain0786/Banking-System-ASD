package edu.mum.cs.cs525.project.bank.observer;

import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.AccountEntryInfo;
import edu.mum.cs.cs525.project.framework.observer.Observer;

public class EmailSender implements Observer<AccountEntryInfo> {

    private static final EmailSender INSTANCE = new EmailSender();

    public static EmailSender getInstance(){
        return INSTANCE;
    }

    @Override
    public void update(AccountEntryInfo data) {
        System.out.println("Email sent");
    }
}
