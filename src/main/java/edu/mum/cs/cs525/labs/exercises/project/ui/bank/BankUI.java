package edu.mum.cs.cs525.labs.exercises.project.ui.bank;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.GuiForm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class BankUI extends GuiForm {


    public BankUI() {
        super();
    }

    @Override
    public String loadJsonFile() throws IOException, URISyntaxException {
        return Files.readString(Path.of(Objects.requireNonNull(getClass().getResource("/bankui.json")).toURI()));
    }

    @Override
    public void setUIListeners() {
        ((JButton) findViewById("exit")).addActionListener(event -> exitApplication());
        ((JButton) findViewById("add_personal_acc_btn")).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddPAccPopup accPopup = new AddPAccPopup();
                accPopup.start();
            }
        });

    }
}
