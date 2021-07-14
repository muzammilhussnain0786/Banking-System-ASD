package edu.mum.cs.cs525.labs.exercises.project.ui.ccard;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.GuiForm;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class CardUI extends GuiForm {

    public CardUI() {
        super();
    }

    @Override
    public String loadJsonFile() throws IOException, URISyntaxException {
        return Files.readString(Path.of(Objects.requireNonNull(getClass().getResource("/cardui.json")).toURI()));
    }

    @Override
    public void setUIListeners() {
        ((JButton) findViewById("exit")).addActionListener(event -> exitApplication());
    }

}
