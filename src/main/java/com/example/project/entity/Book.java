package com.example.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import jakarta.persistence.*;

import javax.persistence.*;

@Entity
@Table(name = "book")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @OneToOne(mappedBy = "book")
    protected BorrowedBook borrowedBook;
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private String isbn;
    private String name;
    private String genre;
    private String description;
    private String author;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
