package edu.mum.cs.cs525.project.framework.uitoolkit.adapter;

import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.observer.Observer;
import edu.mum.cs.cs525.project.framework.uitoolkit.TableRow;
import edu.mum.cs.cs525.project.framework.uitoolkit.composite.JTableView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTableAdapter extends JTable implements Observer<Account> {

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


    @Override
    public void update(Account data) {
        //((TableRow) data)
        //["AccountNr", "Name", "City", "P/C", "Ch/S", "Amount"]
        model.addRow(new Object[]{data.getAccountNumber()});
        model.fireTableDataChanged();
    }
}
