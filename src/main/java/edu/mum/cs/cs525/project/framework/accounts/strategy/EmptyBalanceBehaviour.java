package edu.mum.cs.cs525.project.framework.accounts.strategy;

public class EmptyBalanceBehaviour implements BalanceBehaviour {

    @Override
    public double getResult(double balance){
        return  balance;
    }
}
