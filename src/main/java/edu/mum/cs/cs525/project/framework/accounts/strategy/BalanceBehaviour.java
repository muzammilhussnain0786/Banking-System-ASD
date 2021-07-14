package edu.mum.cs.cs525.project.framework.accounts.strategy;

import java.io.Serializable;

public interface BalanceBehaviour extends Serializable{

    double getResult(double balance);
}
