package edu.mum.cs.cs525.project.bank;

import edu.mum.cs.cs525.project.bank.model.CheckingAccount;
import edu.mum.cs.cs525.project.bank.model.SavingAccount;
import edu.mum.cs.cs525.project.bank.observer.EmailSender;
import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.AccountEntry;
import edu.mum.cs.cs525.project.framework.accounts.facade.DatabaseAccountService;
import edu.mum.cs.cs525.project.framework.observer.Observer;
import edu.mum.cs.cs525.project.framework.uitoolkit.GuiForm;
import edu.mum.cs.cs525.project.framework.uitoolkit.TableRow;
import edu.mum.cs.cs525.project.framework.uitoolkit.adapter.JTableAdapter;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class BankUI extends GuiForm {

    public BankUI() {
        super();
    }

    @Override
    public String loadJsonFile() throws IOException, URISyntaxException {
        return Files.readString(Path.of(Objects.requireNonNull(getClass().getResource("/bankui.json")).toURI()));
    }

    @Override
    public void setUIListeners() {

        ((JButton) findViewById("exit")).addActionListener(event -> exitApplication());

        ((JButton) findViewById("add_personal_acc_btn")).addActionListener(e -> {
            AddPAccPopup accPopup = new AddPAccPopup();
            accPopup.start();
        });

        ((JButton) findViewById("add_company_acc_btn")).addActionListener(e -> {
            AddCAccPopup accPopup = new AddCAccPopup();
            accPopup.start();
        });
        ((JButton) findViewById("withdraw_btn")).addActionListener(e -> {
            WithDrawPopup accPopup = new WithDrawPopup(getSelectedAccountNumber());
            accPopup.start();
        });
        ((JButton) findViewById("deposit_btn")).addActionListener(e -> {
            DepositPopup accPopup = new DepositPopup(getSelectedAccountNumber());
            accPopup.start();
        });
    }

    private String getSelectedAccountNumber() {
        JTableAdapter acc_table = (JTableAdapter) findViewById("acc_table");
        int rowIndex = acc_table.getSelectedRow();
        String accountNumber = acc_table.getModel().getValueAt(rowIndex, 0).toString();
        return accountNumber;
    }

    @Override
    public void hook() {
        DatabaseAccountService.getInstance().getAllAccounts().forEach(account -> {
            ((JTableAdapter) findViewById("acc_table")).update(account);
        });
        DatabaseAccountService.getInstance().attach(SavingAccount.class, ((Observer<Account>) findViewById("acc_table")));
        DatabaseAccountService.getInstance().attach(CheckingAccount.class, ((Observer<Account>) findViewById("acc_table")));
    }
}
