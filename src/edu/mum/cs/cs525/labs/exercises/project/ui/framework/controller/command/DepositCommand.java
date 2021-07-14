package edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller.command;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller.response.Response;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.Entity;

public class DepositCommand extends AbstractCommand {

    Account account;
    Entity entity;
    public DepositCommand(Account account, Entity entity){
        this.account = account;
        this.entity = entity;
    }

    @Override
    public Response execute() {
        System.out.println("Money has been deposited, amount: "+entity.getChangedDate());
//        account.deposit(entity);
        return null;
    }

}
