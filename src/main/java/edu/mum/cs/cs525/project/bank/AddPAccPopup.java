package edu.mum.cs.cs525.project.bank;

import edu.mum.cs.cs525.project.bank.model.CheckingAccount;
import edu.mum.cs.cs525.project.bank.model.PersonalCustomer;
import edu.mum.cs.cs525.project.bank.model.SavingAccount;
import edu.mum.cs.cs525.project.bank.strategy.CheckingAccountInterestBehaviour;
import edu.mum.cs.cs525.project.bank.strategy.SavingAccountInterestBehaviour;
import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.Owner;
import edu.mum.cs.cs525.project.framework.accounts.facade.DatabaseAccountService;
import edu.mum.cs.cs525.project.framework.proxy.LoggingInvocationHandler;
import edu.mum.cs.cs525.project.framework.uitoolkit.GuiForm;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class AddPAccPopup extends GuiForm {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4084371213233733791L;
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

        JRadioButton checking_radio = (JRadioButton) findViewById("checking_radio");
        Account account = null;
        if (checking_radio.isSelected()){
           account =  new CheckingAccount(txtAccNumber.getText(), new CheckingAccountInterestBehaviour());
        } else {
            account = new SavingAccount(txtAccNumber.getText(), new SavingAccountInterestBehaviour());
        }
        Owner owner = new PersonalCustomer(txtName.getText());
        owner.setCity(txtCity.getText());

        account.setOwner(owner);
        account.setOwner(owner);
        databaseAccountService.createAccount(account);
    }
}
