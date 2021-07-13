package edu.mum.cs.cs525.labs.exercises.project.ui.ccard.model;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.Account;

public abstract class CreditAccount extends Account {
    public static final String GOLD  = "Gold";
    public static final String SILIVER = "Silver";
    public static final String BRONZE = "Bronze";

    public CreditAccount(Long id) {
        super(id);
    }
}
