package edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.account;

public interface IAccount {
    void addInterest();
    double getInterest();
    String getAccountType();
    default double getMP() {return  0D;}
}
