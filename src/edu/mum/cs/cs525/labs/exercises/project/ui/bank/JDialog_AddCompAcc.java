package edu.mum.cs.cs525.labs.exercises.project.ui.bank;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.view.AddAccountDialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;



public class JDialog_AddCompAcc extends AddAccountDialog
{
    private BankFrm parentframe;

	private static final Map<String, String> accountTypeMap = new HashMap<>();

	static {
		accountTypeMap.put("Checkings", "Ch");
		accountTypeMap.put("Savings", "S");
	}

	public JDialog_AddCompAcc(BankFrm parent) {
		super(parent, "Add compamy account");
		parentframe=parent;

		JLabel1.setText("Name");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(Color.black);
		JLabel1.setBounds(12,96,48,24);
		JLabel2.setText("Street");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(Color.black);
		JLabel2.setBounds(12,120,48,24);
		JLabel3.setText("City");
		getContentPane().add(JLabel3);
		JLabel3.setForeground(Color.black);
		JLabel3.setBounds(12,144,48,24);
		JLabel4.setText("State");
		getContentPane().add(JLabel4);
		JLabel4.setForeground(Color.black);
		JLabel4.setBounds(12,168,48,24);
		JLabel5.setText("Zip");
		getContentPane().add(JLabel5);
		JLabel5.setForeground(Color.black);
		JLabel5.setBounds(12,192,48,24);
		JLabel6.setText("No of employees");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(Color.black);
		JLabel6.setBounds(12,216,96,24);
		JLabel7.setText("Email");
		getContentPane().add(JLabel7);
		JLabel7.setForeground(Color.black);
		JLabel7.setBounds(12,240,48,24);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(120,96,156,20);
		getContentPane().add(JTextField_CT);
		JTextField_CT.setBounds(120,144,156,20);
		getContentPane().add(JTextField_ST);
		JTextField_ST.setBounds(120,168,156,20);
		getContentPane().add(JTextField_STR);
		JTextField_STR.setBounds(120,120,156,20);
		getContentPane().add(JTextField_ZIP);
		JTextField_ZIP.setBounds(120,192,156,20);
		getContentPane().add(JTextField_NoOfEmp);
		JTextField_NoOfEmp.setBounds(120,216,156,20);
		getContentPane().add(JTextField_EM);
		JTextField_EM.setBounds(120,240,156,20);
		JLabel8.setText("Acc Nr");
		getContentPane().add(JLabel8);
		JLabel8.setForeground(Color.black);
		JLabel8.setBounds(12,72,48,24);
		getContentPane().add(JTextField_ACNR);
		JTextField_ACNR.setBounds(120,72,156,20);
		//}}
	}

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
	JTextField JTextField_NoOfEmp = new JTextField();
	JTextField JTextField_EM = new JTextField();
	JLabel JLabel8 = new JLabel();
	JTextField JTextField_ACNR = new JTextField();

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