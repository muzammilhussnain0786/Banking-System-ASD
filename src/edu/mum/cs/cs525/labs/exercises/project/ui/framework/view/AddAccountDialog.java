package edu.mum.cs.cs525.labs.exercises.project.ui.framework.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public abstract class AddAccountDialog extends JDialog {
    private MainFrame parentFrame;

    private ButtonGroup buttonGroup;

    public AddAccountDialog(MainFrame mainFrame, String title) {
        super(mainFrame);
        initDialog(title);
        //Add options getContentPane().
        addButtonGroup(createRadioButton());
        //Add form
        //TODO create form
        //Add ok/cancel buttons
        addOkButton();
        addCancelButton();
    }

    protected List<JRadioButton> createRadioButton() {
        int y = 0;
        List<JRadioButton> list = new ArrayList<>();
        for (String option : generatedOptions()) {
            JRadioButton jRadioButton = new JRadioButton(option);
            jRadioButton.setText(option);
            jRadioButton.setActionCommand(option);
            jRadioButton.setBounds(36, y, 120, 24);
            y += 24;
            list.add(jRadioButton);
        }
        return list;
    }

    public abstract List<String> generatedOptions();

    public abstract void okActionEvent(ActionEvent e);

    public String getSelection() {
        ButtonModel selection = buttonGroup.getSelection();
        return selection != null ? selection.getActionCommand() : "";
    }

    private void addButtonGroup(List<JRadioButton> buttons) {
        buttonGroup = new ButtonGroup();
        for (JRadioButton jRadioButton : buttons) {
            buttonGroup.add(jRadioButton);
            this.getContentPane().add(jRadioButton);
        }
    }

    private void addCancelButton() {
        JButton JButton_Cancel = new JButton();
        JButton_Cancel.setText("Cancel");
        JButton_Cancel.setActionCommand("Cancel");
        JButton_Cancel.setBounds(156, 264, 84, 24);
        JButton_Cancel.addActionListener(e -> dispose());
        getContentPane().add(JButton_Cancel);
    }

    private void addOkButton() {
        JButton JButton_OK = new JButton();

        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        JButton_OK.setBounds(48, 264, 84, 24);
        JButton_OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                okActionEvent(e);
            }
        });

        getContentPane().add(JButton_OK);
    }

    private void initDialog(String title) {
        setTitle(title);
        setModal(true);
        getContentPane().setLayout(null);
        setSize(283, 303);
        setVisible(false);
    }
}
