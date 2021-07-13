package edu.mum.cs.cs525.project.framework.controller.command;

public interface Command {
    void execute();
    void undo();
}
