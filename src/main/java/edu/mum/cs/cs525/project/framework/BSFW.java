package edu.mum.cs.cs525.project.framework;

import javax.swing.*;

public class BSFW extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
