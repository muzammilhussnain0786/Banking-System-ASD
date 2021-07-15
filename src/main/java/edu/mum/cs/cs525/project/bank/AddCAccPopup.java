package edu.mum.cs.cs525.project.bank;

import edu.mum.cs.cs525.project.bank.model.*;
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

public class AddCAccPopup extends GuiForm {
    DatabaseAccountService databaseAccountService = DatabaseAccountService.getInstance();

    public AddCAccPopup() {
        super(true);
    }

    @Override
    public String loadJsonFile() throws IOException, URISyntaxException {
        return Files.readString(Path.of(Objects.requireNonNull(getClass().getResource("/addCompanyAccountPopup.json")).toURI()));
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
        JTextField txtNoOfEmp = (JTextField) findViewById("txtNoOfEmp");
        JRadioButton checking_radio = (JRadioButton) findViewById("checking_radio");

        Account account = new AccountFactory().getAccount(checking_radio.isSelected() ? "Ch" : "S", txtAccNumber.getText());
        Owner owner = new Company(txtName.getText(), txtCity.getText(), txtEmail.getText(), txtState.getText(), txtZip.getText(), Integer.parseInt(txtNoOfEmp.getText()));

        account.setOwner(owner);
        owner.addAccount(account);

        databaseAccountService.createAccount(account);
    }
}
