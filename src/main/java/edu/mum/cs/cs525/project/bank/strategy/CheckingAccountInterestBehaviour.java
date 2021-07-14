package edu.mum.cs.cs525.project.bank.strategy;

import edu.mum.cs.cs525.project.framework.accounts.strategy.BalanceBehaviour;

public class CheckingAccountInterestBehaviour implements BalanceBehaviour {

    @Override
    public double getResult(double balance) {
        if (balance < 1000){
            return balance * 0.015;
        }else{
            return balance * 0.025;
        }
    }
}
