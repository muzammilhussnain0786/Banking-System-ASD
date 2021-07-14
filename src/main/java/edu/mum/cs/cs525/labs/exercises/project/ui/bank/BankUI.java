package edu.mum.cs.cs525.labs.exercises.project.ui.bank;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.GuiForm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
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
}
