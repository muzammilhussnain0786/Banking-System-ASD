package edu.mum.cs.cs525.project.framework.uitoolkit.adapter;

import edu.mum.cs.cs525.project.framework.uitoolkit.composite.JTextAreaView;

import javax.swing.*;

public class JTextAreaAdapter extends JTextArea {

    JTextAreaView jTextAreaView;

    public JTextAreaAdapter(JTextAreaView jTextAreaView) {
        this.jTextAreaView = jTextAreaView;
        setBounds(this.jTextAreaView.getX().intValue(), this.jTextAreaView.getY().intValue(),
                this.jTextAreaView.getWidth().intValue(), this.jTextAreaView.getHeight().intValue());
    }
}
