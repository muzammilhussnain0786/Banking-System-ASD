package edu.mum.cs.cs525.project.framework.controller.command;

import edu.mum.cs.cs525.project.framework.controller.response.CurrentBalance;
import edu.mum.cs.cs525.project.framework.controller.response.Response;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.account.Account;

public class DepositCommand extends AbstractCommand {

    Account account;
    AccountEntry accountEntry;

    public DepositCommand(Account account, AccountEntry accountEntry) {
        this.account = account;
        this.accountEntry = accountEntry;
    }

    @Override
    public Response execute() {
        System.out.println("Deposit called with account: " + account.getId() + " amount: " + accountEntry.getAmount());
        account.addEntry(accountEntry);
        return new CurrentBalance(account.getCurrentBalance(), CurrentBalance.SUCCESS);
    }

}
