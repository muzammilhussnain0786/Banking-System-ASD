package edu.mum.cs.cs525.project.framework.controller.command;

import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.AccountEntry;
import edu.mum.cs.cs525.project.framework.controller.response.CurrentBalance;
import edu.mum.cs.cs525.project.framework.controller.response.Response;

public class WithdrawCommand extends AbstractCommand {
    Account account;
    AccountEntry accountEntry;
    public WithdrawCommand(Account account, AccountEntry accountEntry){
        this.account = account;
        this.accountEntry = accountEntry;
    }
    @Override
    public Response execute() {
//        accountEntry.setAmount(-1 * accountEntry.getAmount());
//        account.addEntry(accountEntry);
//        if (account.getCurrentBalance() < 0)
//            return new CurrentBalance(account.getCurrentBalance(), CurrentBalance.NEGATIVE_BALANCE);
//        return new CurrentBalance(account.getCurrentBalance(), CurrentBalance.SUCCESS);
        return null;
    }
}
