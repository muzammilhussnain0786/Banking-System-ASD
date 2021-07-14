package edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.account;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.Entity;

import java.util.ArrayList;
import java.util.List;

public class Account implements IAccount{
    private String id;
    private double currentBalance;
    private List<Entity> entries;
    public Account() {
        this.currentBalance = currentBalance;
        entries = new ArrayList<>();
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Entity> getEntries() {
        return entries;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void addEntry(Entity entry) {
        currentBalance += entry.getAmount();
        this.entries.add(entry);
    }

    @Override
    public void addInterest() {

    }

    @Override
    public double getInterest() {
        return 0;
    }

    @Override
    public String getAccountType() {
        return null;
    }
}
