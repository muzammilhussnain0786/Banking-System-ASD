package edu.mum.cs.cs525.project.ccard;

import edu.mum.cs.cs525.project.framework.BankingFramework;

public class CardApplication {

    public static void main(String[] args){
        BankingFramework.run(CardUI.class, args);
    }
}
