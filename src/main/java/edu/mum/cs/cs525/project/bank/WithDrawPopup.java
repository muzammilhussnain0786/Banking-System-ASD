package edu.mum.cs.cs525.project.bank;

import edu.mum.cs.cs525.project.framework.uitoolkit.GuiForm;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class WithDrawPopup extends GuiForm {


    /**
	 * 
	 */
	private static final long serialVersionUID = 3518144077377102572L;

	public WithDrawPopup() {
        super(true);
    }

    @Override
    public String loadJsonFile() throws IOException, URISyntaxException {
        return Files.readString(Path.of(Objects.requireNonNull(getClass().getResource("/withDrawPopup.json")).toURI()));
    }

    @Override
    public void setUIListeners() {
        ((JButton) findViewById("btnCancel")).addActionListener(event -> exitApplication());
    }
}
