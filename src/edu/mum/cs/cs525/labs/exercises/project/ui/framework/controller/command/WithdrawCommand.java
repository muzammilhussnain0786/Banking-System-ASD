package edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller.command;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller.response.Response;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.BaseEntity;

public class WithdrawCommand extends AbstractCommand {
    Account account;
    BaseEntity entity;
    public WithdrawCommand(Account account, BaseEntity entity){
        this.account = account;
        this.entity = entity;
    }
    @Override
    public Response execute() {
//        System.out.println("Withdraw money amount "+account.getCurrentBalance());
//        this.account.setCurrentBalance(entity.getRequestAmount());
        return null;
    }
}
