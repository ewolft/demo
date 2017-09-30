package com.footbridge.demo.com.footbridge.demo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    private String first;
    private String last;

    @ManyToMany
    @JoinTable(name="author_book", joinColumns = @JoinColumn(name="book_id"),
    inverseJoinColumns = @JoinColumn(name="author_id"))
    private Set<Book> books = new HashSet<Book>();

    public Author(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public Author(String first, String last, Set<Book> books) {
        this.first = first;
        this.last = last;
        this.books = books;
    }

    public Author() {
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (!id.equals(author.id)) return false;
        if (!first.equals(author.first)) return false;
        return last.equals(author.last);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + first.hashCode();
        result = 31 * result + last.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Author{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }
}
