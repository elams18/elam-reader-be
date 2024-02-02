package com.be.elamreader.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
public class Book {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID book_id;

    private String title;
    private String author;

    private Integer publication_year;

    private String isbn;

    @JsonProperty("reader_id")
    private UUID reader_id;

    public Integer getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(Integer publication_year) {
        this.publication_year = publication_year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getReader_id() {
        return reader_id;
    }

    public void setReader_id(UUID reader_id) {
        this.reader_id = reader_id;
    }
}
