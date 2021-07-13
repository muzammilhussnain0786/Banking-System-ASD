package edu.mum.cs.cs525.labs.exercises.project.ui.framework.model;

import java.time.LocalDate;

public class Entry {
	private double amount;
	private LocalDate date;
	private String entryType;

	public Entry(double amount, LocalDate date, String entryType) {
		this.amount = amount;
		this.date = date;
		this.entryType = entryType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getEntryType() {
		return this.entryType ;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}