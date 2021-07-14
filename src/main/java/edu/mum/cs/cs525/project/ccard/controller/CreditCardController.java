package edu.mum.cs.cs525.project.ccard.controller;

import edu.mum.cs.cs525.project.framework.controller.CommandControl;
import edu.mum.cs.cs525.project.framework.controller.Controller;
import edu.mum.cs.cs525.project.framework.controller.command.AddInterestCommand;
import edu.mum.cs.cs525.project.framework.controller.command.DepositCommand;
import edu.mum.cs.cs525.project.framework.controller.command.WithdrawCommand;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.account.Account;

public class CreditCardController extends Controller {
    CommandControl commandControl;

    @Override
    public void deposit(AccountEntry entry, Account account) {
        System.out.println("Credit Card Depositing  " + account.getCurrentBalance());
        commandControl = new CommandControl(new DepositCommand(account, entry));
        commandControl.startCommandExecute();
    }

    @Override
    public void withdraw(AccountEntry entry, Account account) {
        System.out.println("Credit Card Withdrawing  " + account.getCurrentBalance());
        commandControl = new CommandControl(new WithdrawCommand(account, entry));
        commandControl.startCommandExecute();
    }

    @Override
    public void addInterest() {
        System.out.println("Credit Card adding Interest  ");
        commandControl = new CommandControl(new AddInterestCommand());
        commandControl.startCommandExecute();
    }

    @Override
    public void addAccount(Account account) {
        System.out.println("Credit Card adding new Account  ");
    }
}
