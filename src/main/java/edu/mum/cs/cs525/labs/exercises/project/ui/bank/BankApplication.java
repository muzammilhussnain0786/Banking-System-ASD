package edu.mum.cs.cs525.labs.exercises.project.ui.bank;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.BankingFramework;

public class BankApplication {

    public static void main(String[] args){
        BankingFramework.run(BankUI.class, args);
    }
}
