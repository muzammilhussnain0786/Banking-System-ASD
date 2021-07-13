package edu.mum.cs.cs525.labs.exercises.project.ui.framework.command;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.BaseEntity;

public class WithdrawCommand implements Command {
    Account account;
    BaseEntity entity;
    public WithdrawCommand(Account account, BaseEntity entity){
        this.account = account;
        this.entity = entity;
    }
    @Override
    public void execute() {
        System.out.println("Withdraw money amount "+account.getCurrentBalance());
//        this.account.setCurrentBalance(entity.getRequestAmount());
    }

    @Override
    public void undo() {
        // todo undo operation goes in here
    }
}
