package edu.mum.cs.cs525.project.ccard;

import edu.mum.cs.cs525.project.bank.AddCAccPopup;
import edu.mum.cs.cs525.project.bank.AddPAccPopup;
import edu.mum.cs.cs525.project.bank.DepositPopup;
import edu.mum.cs.cs525.project.bank.WithDrawPopup;
import edu.mum.cs.cs525.project.framework.uitoolkit.GuiForm;

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
            AddCAccPopup accPopup = new AddCAccPopup();
            accPopup.start();
        });
        ((JButton) findViewById("add_interest_btn")).addActionListener(e -> {
            WithDrawPopup accPopup = new WithDrawPopup();
            accPopup.start();
        });
        ((JButton) findViewById("deposit_btn")).addActionListener(e -> {
            DepositPopup accPopup = new DepositPopup();
            accPopup.start();
        });

        ((JButton) findViewById("add_charge_btn")).addActionListener(e -> {
            DepositPopup accPopup = new DepositPopup();
            accPopup.start();
        });

        ((JButton) findViewById("btnCancel")).addActionListener(event -> exitApplication());
    }

    @Override
    public void hook() {

    }

}
