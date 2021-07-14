package edu.mum.cs.cs525.project.framework.accounts;

public class AccountEntryInfo {

    Account account;
    AccountEntry entry;

    public AccountEntryInfo(Account account, AccountEntry entry) {
        this.account = account;
        this.entry = entry;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public AccountEntry getEntry() {
        return entry;
    }

    public void setEntry(AccountEntry entry) {
        this.entry = entry;
    }
}
