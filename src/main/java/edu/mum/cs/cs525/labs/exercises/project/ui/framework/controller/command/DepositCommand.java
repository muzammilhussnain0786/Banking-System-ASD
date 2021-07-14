package edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller.command;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller.response.CurrentBalance;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller.response.Response;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.account.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.Entity;

public class DepositCommand extends AbstractCommand {

    Account account;
    Entity entity;

    public DepositCommand(Account account, Entity entity) {
        this.account = account;
        this.entity = entity;
    }

    @Override
    public Response execute() {
        System.out.println("Deposit called with account: " + account.getId() + " amount: " + entity.getAmount());
        account.addEntry(entity);
        return new CurrentBalance(account.getCurrentBalance(), CurrentBalance.SUCCESS);
    }

}
