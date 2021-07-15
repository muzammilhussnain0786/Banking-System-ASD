package edu.mum.cs.cs525.project.bank;

import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.facade.DatabaseAccountService;
import edu.mum.cs.cs525.project.framework.uitoolkit.GuiForm;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Objects;

public class GenerateReportPopup extends GuiForm {

    private String accountNumber;

    public GenerateReportPopup(String accountNumber) {
        super(true);
        ((JTextArea) findViewById("txtReport")).setText(prepReport(DatabaseAccountService.getInstance().generateReports()));
        this.accountNumber = accountNumber;
    }

    public String prepReport(Collection<Account> accounts){
        var report = new StringBuilder();
        accounts.forEach(account -> report.append(account.toString()).append("\n"));
        return report.toString();
    }

    @Override
    public String loadJsonFile() throws IOException, URISyntaxException {
        return Files.readString(Path.of(Objects.requireNonNull(getClass().getResource("/reportPopup.json")).toURI()));
    }

    @Override
    public void setUIListeners() {
        ((JButton) findViewById("btnOk")).addActionListener(event -> exitApplication());
    }
}
