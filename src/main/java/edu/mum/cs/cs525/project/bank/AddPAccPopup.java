package edu.mum.cs.cs525.project.bank;

import edu.mum.cs.cs525.project.bank.model.AccountFactory;
import edu.mum.cs.cs525.project.bank.model.CheckingAccount;
import edu.mum.cs.cs525.project.bank.model.PersonalCustomer;
import edu.mum.cs.cs525.project.bank.model.SavingAccount;
import edu.mum.cs.cs525.project.bank.strategy.CheckingAccountInterestBehaviour;
import edu.mum.cs.cs525.project.bank.strategy.SavingAccountInterestBehaviour;
import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.Owner;
import edu.mum.cs.cs525.project.framework.accounts.facade.DatabaseAccountService;
import edu.mum.cs.cs525.project.framework.uitoolkit.GuiForm;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class AddPAccPopup extends GuiForm {

    DatabaseAccountService databaseAccountService = DatabaseAccountService.getInstance();

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
            exitApplication();
        });
    }

    private void createAccount(){
        JTextField txtAccNumber = (JTextField) findViewById("txtAccNumber");
        JTextField txtName = (JTextField) findViewById("txtName");
        JTextField txtCity = (JTextField) findViewById("txtCity");
        JTextField txtEmail = (JTextField) findViewById("txtEmail");
        JTextField txtZip = (JTextField) findViewById("txtZip");
        JTextField txtState = (JTextField) findViewById("txtState");
        JTextField txtBirthDate = (JTextField) findViewById("txtBirthDate");
        JRadioButton checking_radio = (JRadioButton) findViewById("checking_radio");

        Account account = new AccountFactory().getAccount(checking_radio.isSelected() ? "Ch" : "S", txtAccNumber.getText());
        Owner owner = new PersonalCustomer(txtName.getText(), txtCity.getText(), txtEmail.getText(), txtState.getText(), txtZip.getText(), txtBirthDate.getText());

        account.setOwner(owner);
        owner.addAccount(account);
        databaseAccountService.createAccount(account);
    }
}
