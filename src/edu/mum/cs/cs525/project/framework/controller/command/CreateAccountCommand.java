package edu.mum.cs.cs525.project.framework.controller.command;

import edu.mum.cs.cs525.project.framework.model.Account;

public class CreateAccountCommand implements Command {
//    BaseController controller;
    Account account;
//    public CreateAccountCommand(BaseController controller, Account account){
//        this.controller = controller;
//        this.account = account;
//    }

    @Override
    public void execute() {
        System.out.println("created a new customer");
//        this.controller.createAccount(account);
    }

    @Override
    public void undo() {

    }
}
