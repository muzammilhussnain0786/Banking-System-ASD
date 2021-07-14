package edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.adapter;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.composite.JTextFieldView;

import javax.swing.*;

public class JTextFieldAdapter extends JTextField {

    JTextFieldView textFieldView;

    public JTextFieldAdapter(JTextFieldView textFieldView) {
        this.textFieldView = textFieldView;
        setText(this.textFieldView.getTitle());
        setBounds(this.textFieldView.getX().intValue(), this.textFieldView.getY().intValue(),
                this.textFieldView.getWidth().intValue(), this.textFieldView.getHeight().intValue());
    }
}
