package edu.mum.cs.cs525.labs.exercises.project.ui.bank.controller;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller.CommandControl;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller.Controller;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller.command.AddInterestCommand;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller.command.DepositCommand;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller.command.WithdrawCommand;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.Entity;

public class BankController extends Controller {

    CommandControl commandControl;

    public BankController() {
    }

    @Override
    public void deposit(Entity entry, Account account) {
        System.out.println("Depositing  " + account.getCurrentBalance());
        commandControl = new CommandControl(new DepositCommand(account, entry));
        commandControl.startCommandExecute();
    }

    @Override
    public void withdraw(Entity entry, Account account) {
        System.out.println("Withdrawing  " + account.getCurrentBalance());
        commandControl = new CommandControl(new WithdrawCommand(account, entry));
        commandControl.startCommandExecute();
    }

    @Override
    public void addInterest() {
        System.out.println("adding Interest  ");
        commandControl = new CommandControl(new AddInterestCommand());
        commandControl.startCommandExecute();
    }

    @Override
    public void addAccount(Account account) {
        System.out.println("adding Interest  ");
    }
}
