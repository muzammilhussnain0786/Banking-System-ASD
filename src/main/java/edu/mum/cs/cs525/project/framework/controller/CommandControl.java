package edu.mum.cs.cs525.project.framework.controller;

import edu.mum.cs.cs525.project.framework.controller.command.AbstractCommand;
import edu.mum.cs.cs525.project.framework.controller.response.Response;

public class CommandControl {

    AbstractCommand abstractCommand;
    public CommandControl(AbstractCommand abstractCommand){
        this.abstractCommand = abstractCommand;
    }

    public Response startCommandExecute(){
        return abstractCommand.execute();
    }

}

