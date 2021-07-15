package edu.mum.cs.cs525.project.bank.observer;

import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.AccountEntry;
import edu.mum.cs.cs525.project.framework.accounts.AccountEntryInfo;
import edu.mum.cs.cs525.project.framework.observer.Observer;

public class EmailSender implements Observer<AccountEntryInfo> {

    private static final EmailSender INSTANCE = new EmailSender();

    public static EmailSender getInstance() {
        return INSTANCE;
    }

    @Override
    public void update(AccountEntryInfo data) {
        Account ac = data.getAccount();
        AccountEntry entry = data.getEntry();

        StringBuilder sb = new StringBuilder();
        sb.append("Dear " + ac.getOwner().getName());
        sb.append("\n");

        if (entry.getAmount() > 0)
            sb.append("There is a deposit " + entry.getAmount() + " to account " + entry.getFromAccountNumber() + "( " + entry.getDescription() + ")");

        if (entry.getAmount() < 0)
            sb.append("There is a withdraw " + entry.getAmount() + " from account " + entry.getFromAccountNumber() + entry.getFromAccountNumber() + "( " + entry.getDescription() + ")");
        sb.append("\n");
        sb.append("Account balance of  is " + ac.getBalance());
        sb.append("\n");
        sb.append("Thank you");
        sb.append("\n");
        sb.append("ASD Bank");

        System.out.println("Email sent to: " + ac.getOwner().getEmail());
        System.out.println("Email content: " + sb.toString());
    }

}
