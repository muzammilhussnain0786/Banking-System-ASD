package edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller.command;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.BaseEntity;

import javax.swing.*;

public abstract class LoggableAction extends AbstractAction {
	abstract BaseEntity getEntry();
	abstract Account getAccount();
}
