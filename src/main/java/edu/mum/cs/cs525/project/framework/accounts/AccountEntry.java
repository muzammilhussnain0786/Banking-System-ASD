package edu.mum.cs.cs525.project.framework.accounts;

import edu.mum.cs.cs525.project.framework.uitoolkit.TableRow;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountEntry implements Serializable, TableRow {
    private Date date;
    private double amount;
    private String description;
    private String fromAccountNumber;
    private String fromPersonName;

    public AccountEntry() {
    }

    public AccountEntry(double amount, String description, String fromAccountNumber, String fromPersonName) {
        super();
        this.date = new Date();
        this.amount = amount;
        this.description = description;
        this.fromAccountNumber = fromAccountNumber;
        this.fromPersonName = fromPersonName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFromAccountNumber() {
        return fromAccountNumber;
    }

    public void setFromAccountNumber(String fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    public String getFromPersonName() {
        return fromPersonName;
    }

    public void setFromPersonName(String fromPersonName) {
        this.fromPersonName = fromPersonName;
    }

    @Override
    public Object[] row() {
        return new String[]{new SimpleDateFormat("yyyy-MM-dd HH:mm").format(this.date), amount + "", amount < 0 ? "W" : "D"};
    }

	@Override
	public String toString() {
		return "AccountEntry{" +
				"desc=" + description +
				", amount=" + amount +
				", date=" + date +
				"}\n";
	}
}
