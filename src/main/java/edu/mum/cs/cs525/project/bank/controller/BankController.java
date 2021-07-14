package edu.mum.cs.cs525.project.bank.controller;

import edu.mum.cs.cs525.project.framework.controller.CommandControl;
import edu.mum.cs.cs525.project.framework.controller.Controller;
import edu.mum.cs.cs525.project.framework.controller.command.AddInterestCommand;
import edu.mum.cs.cs525.project.framework.controller.command.DepositCommand;
import edu.mum.cs.cs525.project.framework.controller.command.WithdrawCommand;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.account.Account;

public class BankController extends Controller {

    CommandControl commandControl;

    public BankController() {
    }

    @Override
    public void deposit(AccountEntry entry, Account account) {
        System.out.println("Bank Depositing  " + account.getCurrentBalance());
        commandControl = new CommandControl(new DepositCommand(account, entry));
        commandControl.startCommandExecute();
    }

    @Override
    public void withdraw(AccountEntry entry, Account account) {
        System.out.println("Bank Withdrawing  " + account.getCurrentBalance());
        commandControl = new CommandControl(new WithdrawCommand(account, entry));
        commandControl.startCommandExecute();
    }

    @Override
    public void addInterest() {
        System.out.println("Bank adding Interest  ");
        commandControl = new CommandControl(new AddInterestCommand());
        commandControl.startCommandExecute();
    }

    @Override
    public void addAccount(Account account) {
        System.out.println("Bank adding new Account  ");
    }
}
