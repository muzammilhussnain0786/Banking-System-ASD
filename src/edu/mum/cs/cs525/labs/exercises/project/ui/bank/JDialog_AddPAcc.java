package edu.mum.cs.cs525.labs.exercises.project.ui.bank;
/*
		A basic implementation of the JDialog class.
*/

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.view.AddAccountDialog;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;

public class JDialog_AddPAcc extends AddAccountDialog {
    private BankFrm parentframe;
	private static final Map<String, String> accountTypeMap = new HashMap<>();

	static {
		accountTypeMap.put("Checkings", "Ch");
		accountTypeMap.put("Savings", "S");
	}
    
	public JDialog_AddPAcc(BankFrm parent)
	{
		super(parent, "Add personal account");
		parentframe=parent;

		JLabel1.setText("Name");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(Color.black);
		JLabel1.setBounds(12,84,48,24);
		JLabel2.setText("Street");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(Color.black);
		JLabel2.setBounds(12,108,48,24);
		JLabel3.setText("City");
		getContentPane().add(JLabel3);
		JLabel3.setForeground(Color.black);
		JLabel3.setBounds(12,132,48,24);
		JLabel4.setText("State");
		getContentPane().add(JLabel4);
		JLabel4.setForeground(Color.black);
		JLabel4.setBounds(12,156,48,24);
		JLabel5.setText("Zip");
		getContentPane().add(JLabel5);
		JLabel5.setForeground(Color.black);
		JLabel5.setBounds(12,180,48,24);
		JLabel6.setText("Birthdate");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(Color.black);
		JLabel6.setBounds(12,204,96,24);
		JLabel7.setText("Email");
		getContentPane().add(JLabel7);
		JLabel7.setForeground(Color.black);
		JLabel7.setBounds(12,228,48,24);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84,84,156,20);
		getContentPane().add(JTextField_CT);
		JTextField_CT.setBounds(84,132,156,20);
		getContentPane().add(JTextField_ST);
		JTextField_ST.setBounds(84,156,156,20);
		getContentPane().add(JTextField_STR);
		JTextField_STR.setBounds(84,108,156,20);
		getContentPane().add(JTextField_ZIP);
		JTextField_ZIP.setBounds(84,180,156,20);
		getContentPane().add(JTextField_BD);
		JTextField_BD.setBounds(84,204,156,20);
		getContentPane().add(JTextField_EM);
		JTextField_EM.setBounds(84,228,156,20);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48,264,84,24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156,264,84,24);
		getContentPane().add(JTextField_ACNR);
		JTextField_ACNR.setBounds(84,60,156,20);
		JLabel8.setText("Acc Nr");
		getContentPane().add(JLabel8);
		JLabel8.setForeground(Color.black);
		JLabel8.setBounds(12,60,48,24);

	}

	//{{DECLARE_CONTROLS

	JLabel JLabel1 = new JLabel();
	JLabel JLabel2 = new JLabel();
	JLabel JLabel3 = new JLabel();
	JLabel JLabel4 = new JLabel();
	JLabel JLabel5 = new JLabel();
	JLabel JLabel6 = new JLabel();
	JLabel JLabel7 = new JLabel();
	JTextField JTextField_NAME = new JTextField();
	JTextField JTextField_CT = new JTextField();
	JTextField JTextField_ST = new JTextField();
	JTextField JTextField_STR = new JTextField();
	JTextField JTextField_ZIP = new JTextField();
	JTextField JTextField_BD = new JTextField();
	JTextField JTextField_EM = new JTextField();
	JButton JButton_OK = new JButton();
	JButton JButton_Cancel = new JButton();
	JTextField JTextField_ACNR = new JTextField();
	JLabel JLabel8 = new JLabel();

	@Override
	public List<String> generatedOptions() {
		return new ArrayList<>(accountTypeMap.keySet());
	}

	@Override
	public void okActionEvent(ActionEvent event) {
       parentframe.accountnr=JTextField_ACNR.getText();
       parentframe.clientName=JTextField_NAME.getText();
       parentframe.street=JTextField_STR.getText();
       parentframe.city=JTextField_CT.getText();
       parentframe.zip=JTextField_ZIP.getText();
       parentframe.state=JTextField_ST.getText();
       parentframe.accountType = accountTypeMap.get(this.getSelection());
	   parentframe.newaccount=true;
       dispose();
	}
}