package edu.mum.cs.cs525.labs.exercises.project.ui.framework;

import javax.swing.*;

public class BSFW extends JFrame {

    public void prepareCompany(){
        initializeCommands();
        startUserInterface();
        populateData();
    }

    static public void main(String args[]){
        new BSFW();
    }

    void initializeCommands(){}
    void startUserInterface(){}
    void populateData(){}

}
