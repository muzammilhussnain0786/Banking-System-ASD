package edu.mum.cs.cs525.labs.exercises.project.ui.framework.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Account extends BaseEntity{
    private double currentBalance;
    private List<Entry> entries;

    public Account(Long id) {
        this.currentBalance = 0;
        this.entries = new ArrayList<>();
    }

    public void addEntry(Entry entry) {
        this.currentBalance += entry.getAmount();
        this.entries.add(entry);
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
}
