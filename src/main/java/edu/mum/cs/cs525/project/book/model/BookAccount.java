package edu.mum.cs.cs525.project.book.model;

import edu.mum.cs.cs525.project.framework.accounts.Account;

public class BookAccount extends Account {

    String isbn;
    String title;
    String author;

    public BookAccount(String isbn, String title, String author) {
        super(isbn);
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    @Override
    public Object[] row() {
        return new String[]{isbn, title, author, String.valueOf(getBalance())};
    }

    @Override
    public String toString() {
        return "BookAccount{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", copies='" + copies + '\'' +
                '}';
    }
}
