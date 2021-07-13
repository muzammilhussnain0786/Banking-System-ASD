package edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller.command;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.BaseEntity;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.persistence.AccountDao;

public class WithdrawCommand implements Command {
    AccountDao account;
    BaseEntity entity;
    public WithdrawCommand(AccountDao account, BaseEntity entity){
        this.account = account;
        this.entity = entity;
    }
    @Override
    public void execute() {
//        System.out.println("Withdraw money amount "+account.getCurrentBalance());
//        this.account.setCurrentBalance(entity.getRequestAmount());
    }

    @Override
    public void undo() {
        // todo undo operation goes in here
    }
}
