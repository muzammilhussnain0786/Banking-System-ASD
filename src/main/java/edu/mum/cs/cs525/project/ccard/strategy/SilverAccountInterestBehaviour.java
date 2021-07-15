package edu.mum.cs.cs525.project.ccard.strategy;

import edu.mum.cs.cs525.project.framework.accounts.strategy.BalanceBehaviour;

public class SilverAccountInterestBehaviour implements BalanceBehaviour {

    @Override
    public double getResult(double balance) {
        return balance * 0.08;
    }
}
