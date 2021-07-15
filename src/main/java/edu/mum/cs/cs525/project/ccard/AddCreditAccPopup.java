package edu.mum.cs.cs525.project.ccard;

import edu.mum.cs.cs525.project.ccard.model.BronzeAccount;
import edu.mum.cs.cs525.project.ccard.model.GoldAccount;
import edu.mum.cs.cs525.project.ccard.model.PersonalCreditCustomer;
import edu.mum.cs.cs525.project.ccard.model.SilverAccount;
import edu.mum.cs.cs525.project.ccard.strategy.BronzeAccountInterestBehaviour;
import edu.mum.cs.cs525.project.ccard.strategy.GoldAccountInterestBehaviour;
import edu.mum.cs.cs525.project.ccard.strategy.SilverAccountInterestBehaviour;
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

public class AddCreditAccPopup extends GuiForm {
    DatabaseAccountService databaseAccountService = DatabaseAccountService.getInstance();

    public AddCreditAccPopup() {
        super(true);
    }

    @Override
    public String loadJsonFile() throws IOException, URISyntaxException {
        return Files.readString(Path.of(Objects.requireNonNull(getClass().getResource("/addCreditCardAccountPopup.json")).toURI()));
    }

    @Override
    public void setUIListeners() {
        ((JButton) findViewById("btnCancel")).addActionListener(event -> exitApplication());

        ((JButton) findViewById("btnCancel")).addActionListener(event -> exitApplication());
        ((JButton) findViewById("btnOk")).addActionListener(event -> {
            createAccount();
            exitApplication();
        });
    }

    private void createAccount(){
        JTextField txtAccNumber = (JTextField) findViewById("cc_number_tf");
        JTextField txtName = (JTextField) findViewById("name_tf");
        JTextField txtCity = (JTextField) findViewById("city_tf");
        JTextField txtExpDate = (JTextField) findViewById("exp_date_tf");

        JRadioButton gold_radio = (JRadioButton) findViewById("gold_radio");
        JRadioButton silver_radio = (JRadioButton) findViewById("silver_radio");
        JRadioButton bronze_radio = (JRadioButton) findViewById("bronze_radio");
        Account account = null;
        if (gold_radio.isSelected()){
            account =  new GoldAccount(txtAccNumber.getText(), new GoldAccountInterestBehaviour());
        } else if (silver_radio.isSelected()) {
            account = new SilverAccount(txtAccNumber.getText(), new SilverAccountInterestBehaviour());
        } else {
            account = new BronzeAccount(txtAccNumber.getText(), new BronzeAccountInterestBehaviour());
        }
        account.setExpDate(txtExpDate.getText());
        Owner owner = new PersonalCreditCustomer(txtName.getText());
        owner.setCity(txtCity.getText());


        account.setOwner(owner);
        databaseAccountService.createAccount(account);
    }
}
