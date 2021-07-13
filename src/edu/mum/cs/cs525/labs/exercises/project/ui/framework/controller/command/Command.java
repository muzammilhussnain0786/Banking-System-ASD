package edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller.command;

public interface Command {
    void execute();
    void undo();
}
