package edu.mum.cs.cs525.labs.exercises.project.ui.framework.command;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.BaseEntity;

public class DepositCommand implements Command{

    Account account;
    BaseEntity entity;
    public DepositCommand(Account account, BaseEntity entity){
        this.account = account;
        this.entity = entity;
    }

    @Override
    public void execute() {
        System.out.println("Money has been deposited, amount: "+entity.getChangedDate());
//        account.deposite(entity);
    }

    @Override
    public void undo() {
        // todo undo operation goes here
    }
}
