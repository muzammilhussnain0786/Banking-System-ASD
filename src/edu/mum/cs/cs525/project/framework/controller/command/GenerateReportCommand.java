package edu.mum.cs.cs525.project.framework.controller.command;

import edu.mum.cs.cs525.project.framework.model.Account;

public class GenerateReportCommand implements Command {
    Account account;
    public GenerateReportCommand(Account account){
            this.account = account;
    }

    @Override
    public void execute() {
        System.out.println("Generated Report: "+account.getCurrentBalance());
    }

    @Override
    public void undo() {
        // todo executing undo
    }
}
