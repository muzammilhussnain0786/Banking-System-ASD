package edu.mum.cs.cs525.project.book;

import edu.mum.cs.cs525.project.framework.accounts.facade.DatabaseAccountService;
import edu.mum.cs.cs525.project.framework.uitoolkit.GuiForm;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class AddCopyPopup extends GuiForm {

    private String accountNumber;

    public AddCopyPopup(String accountNumber) {
        super(true);
        ((JTextField) findViewById("txtTitle")).setText(accountNumber);
        this.accountNumber = accountNumber;
    }

    @Override
    public String loadJsonFile() throws IOException, URISyntaxException {
        return Files.readString(Path.of(Objects.requireNonNull(getClass().getResource("/addCopyPopup.json")).toURI()));
    }

    @Override
    public void setUIListeners() {
        ((JButton) findViewById("btnCancel")).addActionListener(event -> exitApplication());
        ((JButton) findViewById("btnOk")).addActionListener(event -> {
            deposit();
        });

    }

    private void deposit() {
        String amountString = ((JTextField) findViewById("txtNoCopies")).getText();
        double amo = amountString != null && !"".equals(amountString) ? Double.parseDouble(amountString) : 0.0;
        DatabaseAccountService.getInstance().deposit(accountNumber, amo);
        exitApplication();
    }
}
