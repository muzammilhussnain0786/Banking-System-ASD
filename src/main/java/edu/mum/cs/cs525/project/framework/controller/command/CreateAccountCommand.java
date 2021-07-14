package edu.mum.cs.cs525.project.framework.controller.command;

import edu.mum.cs.cs525.project.framework.controller.response.Response;

public class CreateAccountCommand extends AbstractCommand {
    @Override
    public Response execute() {
        System.out.println("created a new customer");
        return null;
    }
}
