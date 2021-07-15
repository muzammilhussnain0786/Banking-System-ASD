package edu.mum.cs.cs525.project.book.model;

import edu.mum.cs.cs525.project.framework.accounts.Account;

public class BookAccount extends Account {

    String name;
    public BookAccount(String isbn, String title) {
        super(isbn);
        name = title;
    }

    @Override
    public Object[] row() {
        return new String[]{this.getAccountNumber(), name, this.getOwner().getName(), String.valueOf(this.getBalance())};
    }

}
