package edu.mum.cs.cs525.project.bank;

import edu.mum.cs.cs525.project.framework.BankingFramework;

public class BankApplication {

    public static void main(String[] args){
        BankingFramework.run(BankUI.class, args);
    }
}
