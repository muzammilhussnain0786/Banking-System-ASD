package edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller.command;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.Account;

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
