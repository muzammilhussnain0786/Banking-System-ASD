package edu.mum.cs.cs525.project.book;

import edu.mum.cs.cs525.project.book.model.BookAccount;
import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.facade.DatabaseAccountService;
import edu.mum.cs.cs525.project.framework.uitoolkit.GuiForm;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class AddBookPopup extends GuiForm {

    DatabaseAccountService databaseAccountService = DatabaseAccountService.getInstance();

    public AddBookPopup() {
        super(true);
    }

    @Override
    public String loadJsonFile() throws IOException, URISyntaxException {
        return Files.readString(Path.of(Objects.requireNonNull(getClass().getResource("/addBookPopup.json")).toURI()));
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
        JTextField txtIsbn = (JTextField) findViewById("txtIsbn");
        JTextField txtTitle = (JTextField) findViewById("txtTitle");
        JTextField txtAuthor = (JTextField) findViewById("txtAuthor");

        Account account =  new BookAccount(txtIsbn.getText(),txtTitle.getText(), txtAuthor.getText());
        databaseAccountService.createAccount(account);
    }
}
