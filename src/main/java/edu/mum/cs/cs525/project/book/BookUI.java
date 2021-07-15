package edu.mum.cs.cs525.project.book;

import edu.mum.cs.cs525.project.book.model.BookAccount;
import edu.mum.cs.cs525.project.framework.accounts.facade.DatabaseAccountService;
import edu.mum.cs.cs525.project.framework.observer.Observer;
import edu.mum.cs.cs525.project.framework.uitoolkit.GuiForm;
import edu.mum.cs.cs525.project.framework.uitoolkit.adapter.JTableAdapter;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class BookUI extends GuiForm {

    public BookUI() {
        super();
    }

    @Override
    public String loadJsonFile() throws IOException, URISyntaxException {
        return Files.readString(Path.of(Objects.requireNonNull(getClass().getResource("/bookui.json")).toURI()));
    }

    @Override
    public void setUIListeners() {

        ((JButton) findViewById("exit")).addActionListener(event -> exitApplication());

        ((JButton) findViewById("create_book_btn")).addActionListener(e -> {
            AddBookPopup accPopup = new AddBookPopup();
            accPopup.start();
        });
        ((JButton) findViewById("remove_copy_btn")).addActionListener(e -> {
            DispenseBookPopup accPopup = new DispenseBookPopup(getSelectedAccountNumber());
            accPopup.start();
        });
        ((JButton) findViewById("add_copy_btn")).addActionListener(e -> {
            AddCopyPopup accPopup = new AddCopyPopup(getSelectedAccountNumber());
            accPopup.start();
        });
    }

    private String getSelectedAccountNumber() {
        JTableAdapter acc_table = (JTableAdapter) findViewById("book_table");
        int rowIndex = acc_table.getSelectedRow();
        String accountNumber = String.valueOf(acc_table.getModel().getValueAt(rowIndex, 0));
        return accountNumber;
    }

    @Override
    public void hook() {
        DatabaseAccountService.getInstance().getAllAccounts().forEach(account -> {
            ((JTableAdapter) findViewById("book_table")).update(account);
        });
        DatabaseAccountService.getInstance().attach(BookAccount.class, ((Observer<BookAccount>) findViewById("book_table")));
    }
}
