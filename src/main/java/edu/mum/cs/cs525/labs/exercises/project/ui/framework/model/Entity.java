package edu.mum.cs.cs525.labs.exercises.project.ui.framework.model;

import java.time.LocalDate;

public class Entity extends BaseEntity {
    private double amount;

    public Entity(Long id, String createdBy, String changedBy, LocalDate createdDate, LocalDate changedDate, double amount) {
        super(id, createdBy, changedBy, createdDate, changedDate);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
