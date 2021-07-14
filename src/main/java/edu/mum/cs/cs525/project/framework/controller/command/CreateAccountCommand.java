package edu.mum.cs.cs525.project.framework.controller.command;

import edu.mum.cs.cs525.project.framework.controller.response.Response;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.account.Account;

public class CreateAccountCommand extends AbstractCommand {
//    BaseController controller;
    Account account;
//    public CreateAccountCommand(BaseController controller, Account account){
//        this.controller = controller;
//        this.account = account;
//    }

    @Override
    public Response execute() {
        System.out.println("created a new customer");
//        this.controller.createAccount(account);
        return null;
    }
}
