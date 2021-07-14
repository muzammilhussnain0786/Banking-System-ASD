package edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.adapter;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.composite.JTableView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTableAdapter extends JTable {

    JTableView jTableView;
    private DefaultTableModel model;

    public JTableAdapter(JTableView jTableView) {
        this.jTableView = jTableView;
        model = new DefaultTableModel();
        jTableView.getColumns().forEach(columnName -> model.addColumn(columnName));
        setModel(model);
        setBounds(this.jTableView.getX().intValue(), this.jTableView.getY().intValue(),
                this.jTableView.getWidth().intValue(), this.jTableView.getHeight().intValue());
    }
}
