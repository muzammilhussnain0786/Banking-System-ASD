package edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller.command.Command;

public class CommandControl {

    Command command;
    public CommandControl(Command command){
        this.command = command;
    }

    public void startCommandExecute(){
        command.execute();
    }

    public void startCommandUndo(){
        command.undo();
    }
}

