package edu.mum.cs.cs525.project.framework.controller.command;

import edu.mum.cs.cs525.project.framework.model.Account;
import edu.mum.cs.cs525.project.framework.model.BaseEntity;

public class AddInterestCommand implements Command {

    Account account;
    BaseEntity entity;
    public AddInterestCommand(Account account, BaseEntity entity){
        this.account = account;
        this.entity = entity;
    }

    @Override
    public void execute() {
        // todo executing adding interest
//        account.addInterest();
    }

    @Override
    public void undo() {
        // todo executing undo
    }
}
