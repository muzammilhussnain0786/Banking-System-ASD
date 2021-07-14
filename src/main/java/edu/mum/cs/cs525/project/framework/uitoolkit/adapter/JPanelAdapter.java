package edu.mum.cs.cs525.project.framework.uitoolkit.adapter;

import edu.mum.cs.cs525.project.framework.uitoolkit.composite.JPanelView;

import javax.swing.*;

public class JPanelAdapter extends JPanel {

    JPanelView jPanelView;

    public JPanelAdapter(JPanelView jPanelView) {
        this.jPanelView = jPanelView;
        setBounds(this.jPanelView.getX().intValue(), this.jPanelView.getY().intValue(),
                this.jPanelView.getWidth().intValue(), this.jPanelView.getHeight().intValue());
    }
}
