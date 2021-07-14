package edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.adapter;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.composite.JButtonView;

import javax.swing.*;

public class JButtonAdapter extends JButton {

    JButtonView buttonView;

    public JButtonAdapter(JButtonView buttonView) {
        this.buttonView = buttonView;
        setText(this.buttonView.getTitle());
        setBounds(this.buttonView.getX().intValue(), this.buttonView.getY().intValue(),
                this.buttonView.getWidth().intValue(), this.buttonView.getHeight().intValue());
    }
}
