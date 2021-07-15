package edu.mum.cs.cs525.project.home;

import edu.mum.cs.cs525.project.bank.*;
import edu.mum.cs.cs525.project.ccard.CardApplication;
import edu.mum.cs.cs525.project.ccard.CardUI;
import edu.mum.cs.cs525.project.framework.accounts.facade.DatabaseAccountService;
import edu.mum.cs.cs525.project.framework.uitoolkit.GuiForm;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class HomeUI extends GuiForm {

    public HomeUI() {
        super();
    }

    @Override
    public String loadJsonFile() throws IOException, URISyntaxException {
        return Files.readString(Path.of(Objects.requireNonNull(getClass().getResource("/home.json")).toURI()));
    }

    @Override
    public void setUIListeners() {

        ((JButton) findViewById("exitHome")).addActionListener(event -> exitApplication());

        ((JButton) findViewById("banking_system_btn")).addActionListener(e -> {
            BankUI bankUI = new BankUI();
            bankUI.start();
        });

        ((JButton) findViewById("credit_card_system_btn")).addActionListener(e -> {
            CardUI cardUI = new CardUI();
            cardUI.start();
        });

        ((JButton) findViewById("refreshDb")).addActionListener(e -> {
            DatabaseAccountService.getInstance().refresDb();
        });
    }
}
