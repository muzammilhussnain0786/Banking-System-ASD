package edu.mum.cs.cs525.project.bank.strategy;

import edu.mum.cs.cs525.project.framework.accounts.strategy.BalanceBehaviour;

public class SavingAccountInterestBehaviour implements BalanceBehaviour {

    @Override
    public double getResult(double balance) {
        if (balance < 1000){
            return balance * 0.01;
        }else if (balance > 1000 && balance < 5000){
            return balance * 0.02;
        }else{
            return balance * 0.04;
        }
    }
}
