package edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.account.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.Entity;

public abstract class Controller {


    protected void report() {

    }

    protected abstract void deposit(Entity entry, Account account);

    protected abstract void withdraw(Entity entry, Account account);

    protected abstract void addInterest();

    protected abstract void addAccount(Account account);

}
