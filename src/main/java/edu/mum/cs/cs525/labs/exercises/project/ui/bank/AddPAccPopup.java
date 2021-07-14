package edu.mum.cs.cs525.labs.exercises.project.ui.bank;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.GuiForm;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class AddPAccPopup extends GuiForm {


    public AddPAccPopup() {
        super(true);
    }

    @Override
    public String loadJsonFile() throws IOException, URISyntaxException {
        return Files.readString(Path.of(Objects.requireNonNull(getClass().getResource("/add_account_popup.json")).toURI()));
    }

    @Override
    public void setUIListeners() {
        //((JButton) findViewById("exit")).addActionListener(event -> exitApplication());
    }
}
