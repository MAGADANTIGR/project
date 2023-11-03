package com.example.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import jakarta.persistence.*;
import java.time.LocalDateTime;
import javax.persistence.*;
@Entity
@Table(name = "borrowed_books")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BorrowedBook {
    @Id
    private Long id;

    public void setBook(Book book) {
        this.book = book;
    }

    @OneToOne
    @MapsId
    @JoinColumn(name = "book_id")
    private Book book;
    private LocalDateTime borrowedTime;
    private LocalDateTime returnTime;
    public LocalDateTime getBorrowedTime() {
        return borrowedTime;
    }

    public void setBorrowedTime(LocalDateTime borrowedTime) {
        this.borrowedTime = borrowedTime;
    }

    public LocalDateTime getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalDateTime returnTime) {
        this.returnTime = returnTime;
    }
}
