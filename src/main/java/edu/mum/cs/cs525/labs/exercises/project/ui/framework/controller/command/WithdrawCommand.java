package edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller.command;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller.response.CurrentBalance;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller.response.Response;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.Entity;

public class WithdrawCommand extends AbstractCommand {
    Account account;
    Entity entity;
    public WithdrawCommand(Account account, Entity entity){
        this.account = account;
        this.entity = entity;
    }
    @Override
    public Response execute() {
        entity.setAmount(-1 * entity.getAmount());
        account.addEntry(entity);
        if (account.getCurrentBalance() < 0)
            return new CurrentBalance(account.getCurrentBalance(), CurrentBalance.NEGATIVE_BALANCE);
        return new CurrentBalance(account.getCurrentBalance(), CurrentBalance.SUCCESS);
    }
}
