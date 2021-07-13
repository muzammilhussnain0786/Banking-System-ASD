package edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.BaseEntity;

import java.awt.event.ActionEvent;

public abstract class Controller {


	protected void report(){

	}

	protected abstract void deposit(BaseEntity entry, Account account);

	protected abstract void withdraw(BaseEntity entry, Account account);

	protected abstract void addInterest();

	protected abstract void addAccount(Account account);

}
