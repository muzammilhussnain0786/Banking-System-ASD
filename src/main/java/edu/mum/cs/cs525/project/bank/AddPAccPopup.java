package edu.mum.cs.cs525.project.bank;

import edu.mum.cs.cs525.project.bank.strategy.CheckingAccountBalanceImpl;
import edu.mum.cs.cs525.project.bank.strategy.SavingAccountBalanceImpl;
import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.factory.AccountDAO;
import edu.mum.cs.cs525.project.framework.accounts.factory.DatabaseAccountDAO;
import edu.mum.cs.cs525.project.framework.uitoolkit.GuiForm;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class AddPAccPopup extends GuiForm {

    private AccountDAO dao = new DatabaseAccountDAO();

    public AddPAccPopup() {
        super(true);
    }

    @Override
    public String loadJsonFile() throws IOException, URISyntaxException {
        return Files.readString(Path.of(Objects.requireNonNull(getClass().getResource("/addPersonalAccountPopup.json")).toURI()));
    }

    @Override
    public void setUIListeners() {
        ((JButton) findViewById("btnCancel")).addActionListener(event -> exitApplication());
        ((JButton) findViewById("btnOk")).addActionListener(event -> {
            createAccount();
        });
    }

    private void createAccount(){
        JTextField txtAccNumber = (JTextField) findViewById("txtAccNumber");
        JRadioButton checking_radio = (JRadioButton) findViewById("checking_radio");
        Account account = null;
        if (checking_radio.isSelected()){
           account =  new Account(txtAccNumber.getText(), new CheckingAccountBalanceImpl());
        } else {
            account = new Account(txtAccNumber.getText(), new SavingAccountBalanceImpl());
        }
        dao.saveAccount(account);
        //TODO notify to observer
    }
}
