package edu.mum.cs.cs525.project.ccard;

import edu.mum.cs.cs525.project.bank.AddCAccPopup;
import edu.mum.cs.cs525.project.bank.AddPAccPopup;
import edu.mum.cs.cs525.project.bank.DepositPopup;
import edu.mum.cs.cs525.project.bank.WithDrawPopup;
import edu.mum.cs.cs525.project.bank.model.CheckingAccount;
import edu.mum.cs.cs525.project.bank.model.SavingAccount;
import edu.mum.cs.cs525.project.ccard.model.BronzeAccount;
import edu.mum.cs.cs525.project.ccard.model.GoldAccount;
import edu.mum.cs.cs525.project.ccard.model.SilverAccount;
import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.facade.DatabaseAccountService;
import edu.mum.cs.cs525.project.framework.observer.Observer;
import edu.mum.cs.cs525.project.framework.uitoolkit.GuiForm;
import edu.mum.cs.cs525.project.framework.uitoolkit.adapter.JTableAdapter;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class CardUI extends GuiForm {

    public CardUI() {
        super(true);
    }

    @Override
    public String loadJsonFile() throws IOException, URISyntaxException {
        return Files.readString(Path.of(Objects.requireNonNull(getClass().getResource("/cardui.json")).toURI()));
    }

    @Override
    public void setUIListeners() {

        ((JButton) findViewById("add_credit_card_btn")).addActionListener(e -> {
            AddCreditAccPopup addCreditAccPopup = new AddCreditAccPopup();
            addCreditAccPopup.start();
        });

        ((JButton) findViewById("generate_monthly_bill_btn")).addActionListener(e -> {
            //TODO
        });
        ((JButton) findViewById("add_interest_btn")).addActionListener(e -> {
            DatabaseAccountService.getInstance().executeBalanceBehaviour("");
        });
        ((JButton) findViewById("deposit_btn")).addActionListener(e -> {
            //TODO
            DepositCreditPopup accPopup = new DepositCreditPopup(getSelectedAccountNumber());
            accPopup.start();
        });

        ((JButton) findViewById("add_charge_btn")).addActionListener(e -> {
            //TODO
        });

        ((JButton) findViewById("btnCancel")).addActionListener(event -> exitApplication());
    }

    private String getSelectedAccountNumber() {
        JTableAdapter acc_table = (JTableAdapter) findViewById("acc_table");
        int rowIndex = acc_table.getSelectedRow();
        String accountNumber = acc_table.getModel().getValueAt(rowIndex, 1).toString();
        return accountNumber;
    }

    @Override
    public void hook() {
        DatabaseAccountService.getInstance().getAllAccounts().forEach(account -> {
            ((JTableAdapter) findViewById("acc_table")).update(account);
        });
        DatabaseAccountService.getInstance().attach(GoldAccount.class, ((Observer<Account>) findViewById("acc_table")));
        DatabaseAccountService.getInstance().attach(SilverAccount.class, ((Observer<Account>) findViewById("acc_table")));
        DatabaseAccountService.getInstance().attach(BronzeAccount.class, ((Observer<Account>) findViewById("acc_table")));
    }

}
