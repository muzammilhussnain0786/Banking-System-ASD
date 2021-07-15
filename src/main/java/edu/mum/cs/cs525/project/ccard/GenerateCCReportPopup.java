package edu.mum.cs.cs525.project.ccard;

import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.facade.DatabaseAccountService;
import edu.mum.cs.cs525.project.framework.uitoolkit.GuiForm;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

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
            AtomicReference<Double> previousMonth = new AtomicReference<>((double) 0);
            AtomicReference<Double> totalCredits = new AtomicReference<>((double) 0);
            AtomicReference<Double> totalCharges = new AtomicReference<>((double) 0);
            var deposit = new StringBuilder();
            var withdraw = new StringBuilder();
            var newBalance = new StringBuilder();
            account.getEntryList().forEach(e -> {
                if (e.getDescription().equals("deposit")) {
                    totalCredits.updateAndGet(v -> v + e.getAmount());
                    deposit.append(e).append("\n");
                } else if (e.getDate().getTime() < Date.from(LocalDate.now().withDayOfMonth(1).atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime()) {
                    previousMonth.updateAndGet(v -> v + e.getAmount());
                } else if (e.getDescription().equals("withdraw")) {
                    totalCharges.updateAndGet(v -> v + e.getAmount());
                    withdraw.append(e).append("\n");
                }
            });

            // new balance = previous balance – total credits + total charges + MI * (previous balance – total credits)
            double newBal = previousMonth.get() - totalCharges.get() + totalCredits.get();// +MI
            newBalance.append(newBal);

            var horizontalDivider = "-------------------\n";
            report.append("\nPrevious Balance: \n")
                    .append(horizontalDivider)
                    .append(previousMonth).append("\n")
                    .append("Total Credits: \n")
                    .append(horizontalDivider)
                    .append(withdraw)
                    .append("Total Credits: \n")
                    .append(horizontalDivider)
                    .append(deposit)
                    .append("New Balance: \n")
                    .append(horizontalDivider)
                    .append(newBalance);
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
