package edu.mum.cs.cs525.project.bank;

import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.facade.DatabaseAccountService;
import edu.mum.cs.cs525.project.framework.uitoolkit.GuiForm;
import edu.mum.cs.cs525.project.framework.uitoolkit.adapter.JTableAdapter;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class AccountStatementPopup extends GuiForm {

    private String accountNumber;

    public AccountStatementPopup(String accountNumber) {
        super(true);
        Account account1 = DatabaseAccountService.getInstance().getAccount(accountNumber);

        ((JTextField) findViewById("txtAccNumber")).setText(accountNumber);
        ((JLabel) findViewById("lblAccBalance")).setText(account1.getBalance() + "");

        account1.getEntryList().forEach(accountEntry -> {
            ((JTableAdapter) findViewById("statement_table")).addRow(accountEntry.row());
        });
        this.accountNumber = accountNumber;
    }

    @Override
    public String loadJsonFile() throws IOException, URISyntaxException {
        return Files.readString(Path.of(Objects.requireNonNull(getClass().getResource("/accountStatementPopup.json")).toURI()));
    }

    @Override
    public void setUIListeners() {
    }
}
