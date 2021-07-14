package edu.mum.cs.cs525.project.bank.observer;


import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.AccountEntry;

public class Logger implements Observer{

    @Override
    public void accountChange(Account account, AccountEntry accountEntry) {
        System.out.println(Logger.class.getSimpleName() + " : " + account.getOwner().getName() + " : " + accountEntry.getDescription() + " -> " + accountEntry.getAmount());
    }

}
