package edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.adapter;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.composite.JRadioButtonView;

import javax.swing.*;

public class JRadioButtonAdapter extends JRadioButton {

    JRadioButtonView radioButtonView;

    public JRadioButtonAdapter(JRadioButtonView buttonView) {
        this.radioButtonView = buttonView;
        setText(this.radioButtonView.getTitle());
        setBounds(this.radioButtonView.getX().intValue(), this.radioButtonView.getY().intValue(),
                this.radioButtonView.getWidth().intValue(), this.radioButtonView.getHeight().intValue());
    }
}
