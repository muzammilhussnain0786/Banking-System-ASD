package edu.mum.cs.cs525.project.framework.controller.command;


import edu.mum.cs.cs525.project.framework.accounts.Account;

import javax.swing.*;

public abstract class LoggableAction extends AbstractAction {
	abstract Account getAccount();
}
