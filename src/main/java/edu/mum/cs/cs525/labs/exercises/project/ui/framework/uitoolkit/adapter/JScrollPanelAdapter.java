package edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.adapter;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.composite.JScrollPanelView;

import javax.swing.*;

public class JScrollPanelAdapter extends JScrollPane {

    JScrollPanelView jScrollPanelView;

    public JScrollPanelAdapter(JScrollPanelView jScrollPanelView) {
        this.jScrollPanelView = jScrollPanelView;
        setBounds(this.jScrollPanelView.getX().intValue(), this.jScrollPanelView.getY().intValue(),
                this.jScrollPanelView.getWidth().intValue(), this.jScrollPanelView.getHeight().intValue());
    }
}
