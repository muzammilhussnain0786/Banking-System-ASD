package edu.mum.cs.cs525.labs.exercises.project.ui.framework;

public abstract class StarterTemplate {

    public void prepareCompany(){
        initializeCommands();
        startUserInterface();
        populateData();
    }

    abstract void initializeCommands();
    abstract void startUserInterface();
    abstract void populateData();

}
