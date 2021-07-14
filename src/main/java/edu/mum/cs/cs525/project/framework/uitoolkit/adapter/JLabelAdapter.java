package edu.mum.cs.cs525.project.framework.uitoolkit.adapter;

import edu.mum.cs.cs525.project.framework.uitoolkit.composite.JLabelView;

import javax.swing.*;

public class JLabelAdapter extends JLabel {

    JLabelView labelView;

    public JLabelAdapter(JLabelView labelView) {
        this.labelView = labelView;
        setText(this.labelView.getTitle());
        setBounds(this.labelView.getX().intValue(), this.labelView.getY().intValue(),
                this.labelView.getWidth().intValue(), this.labelView.getHeight().intValue());
    }
}
