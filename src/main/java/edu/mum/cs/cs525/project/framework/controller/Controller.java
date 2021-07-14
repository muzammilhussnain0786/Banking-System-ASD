package edu.mum.cs.cs525.project.framework.controller;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.account.Account;

public abstract class Controller {


    protected void report() {

    }

    protected abstract void deposit(AccountEntry entry, Account account);

    protected abstract void withdraw(AccountEntry entry, Account account);

    protected abstract void addInterest();

    protected abstract void addAccount(Account account);

}
