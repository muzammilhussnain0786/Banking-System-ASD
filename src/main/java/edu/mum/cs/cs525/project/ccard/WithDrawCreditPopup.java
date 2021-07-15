package edu.mum.cs.cs525.project.ccard;

import edu.mum.cs.cs525.project.framework.accounts.facade.DatabaseAccountService;
import edu.mum.cs.cs525.project.framework.uitoolkit.GuiForm;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class WithDrawCreditPopup extends GuiForm {

    private String accountNumber;
    public WithDrawCreditPopup(String accountNumber) {
        super(true);

        ((JTextField) findViewById("txtAccNumber")).setText(accountNumber);
        this.accountNumber = accountNumber;
    }

    @Override
    public String loadJsonFile() throws IOException, URISyntaxException {
        return Files.readString(Path.of(Objects.requireNonNull(getClass().getResource("/withDrawPopup.json")).toURI()));
    }

    @Override
    public void setUIListeners() {
        ((JButton) findViewById("btnCancel")).addActionListener(event -> exitApplication());
        ((JButton) findViewById("btnOk")).addActionListener(event -> {
            String amountString = ((JTextField) findViewById("txtAmount")).getText();
            double amo = amountString != null && !"".equals(amountString) ? Double.parseDouble(amountString) : 0.0;
            DatabaseAccountService.getInstance().withdraw(accountNumber, amo);
            exitApplication();
        });
    }

}
