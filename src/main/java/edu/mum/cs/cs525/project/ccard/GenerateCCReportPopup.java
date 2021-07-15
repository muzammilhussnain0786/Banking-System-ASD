package edu.mum.cs.cs525.project.ccard;

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

public class GenerateCCReportPopup extends GuiForm {

    private final String accountNumber;

    public GenerateCCReportPopup(String accountNumber) {
        super(true);
        ((JTextArea) findViewById("txtReport")).setText(prepReport(DatabaseAccountService.getInstance().generateReports()));
        this.accountNumber = accountNumber;
    }

    public String prepReport(Collection<Account> accounts) {
        var report = new StringBuilder();
        report.append("MONTHLY REPORT\n\n");
        accounts.stream().forEach(account -> {
            var deposit = new StringBuilder();
            var withdraw = new StringBuilder();
            account.getEntryList().forEach(e -> {
                if (e.getDescription().equals("deposit")) {
                    deposit.append(e).append("\n");
                } else if (e.getDescription().equals("withdraw")) {
                    withdraw.append(e).append("\n");
                }
            });
            report.append("Total charges: \n")
                    .append("-------------------\n")
                    .append(deposit)
                    .append("Total Credits: \n")
                    .append("-------------------\n")
                    .append(withdraw);
        });
        accounts.forEach(account -> report.append("\n"));
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
