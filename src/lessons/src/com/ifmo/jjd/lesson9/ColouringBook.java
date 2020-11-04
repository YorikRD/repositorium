package com.ifmo.jjd.lesson9;

import com.ifmo.jjd.lesson6.ColoringBook;
import com.ifmo.jjd.lesson6.ColouringShelf;

import java.util.Objects;

public class ColouringBook extends Book {

    private int picsCount;

    public ColouringBook(String title, int pageCount, int picsCount) {
        super(title, pageCount);
        this.picsCount = picsCount;
    }

    public int getPicsCount() {
        return picsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColouringBook)) return false;

        ColouringBook that = (ColouringBook) o;

        return getPicsCount() == that.getPicsCount() && getAuthor() == that.getAuthor() && getPageCount() == that.getPageCount();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this)+Objects.hashCode(this.getAuthor())+Objects.hashCode(this.getPageCount())+Objects.hashCode(this.getTitle());
    }

    @Override
    protected Object clone()  {
        ColouringBook book = new ColouringBook(this.getTitle(),this.getPageCount(),this.picsCount);
        book.setAuthor(new Author(this.getAuthor().getName(),this.getAuthor().getSurname()));
        return book;
    }

    @Override
    public String toString() {
        return getTitle() + " " + getAuthor() + " " + getPageCount() + "ColouringBook{" +
                "picsCount=" + picsCount +
                '}';
    }
}