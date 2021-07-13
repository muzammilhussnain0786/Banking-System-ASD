package edu.mum.cs.cs525.project.framework.controller.command;

import edu.mum.cs.cs525.project.framework.model.BaseEntity;
import edu.mum.cs.cs525.project.framework.persistence.AccountDao;

public class DepositCommand implements Command {

    AccountDao account;
    BaseEntity entity;
    public DepositCommand(AccountDao account, BaseEntity entity){
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
