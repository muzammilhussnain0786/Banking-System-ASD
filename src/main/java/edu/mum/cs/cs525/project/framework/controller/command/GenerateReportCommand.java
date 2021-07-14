package edu.mum.cs.cs525.project.framework.controller.command;

import edu.mum.cs.cs525.project.framework.controller.response.Response;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.account.Account;

public class GenerateReportCommand extends AbstractCommand {
    Account account;
    public GenerateReportCommand(Account account){
            this.account = account;
    }

    @Override
    public Response execute() {
        System.out.println("Generated Report: "+account.getCurrentBalance());
        return null;
    }

}
