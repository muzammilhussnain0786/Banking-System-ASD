package edu.mum.cs.cs525.labs.exercises.project.ui.bank.model;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.Account;

public abstract class BankingAccount extends Account {
    public static final String SAVING_TYPE  = "Saving";
    public static final String CHECKING_TYPE = "Checking";

    public BankingAccount(Long id) {
        super(id);
    }
}
