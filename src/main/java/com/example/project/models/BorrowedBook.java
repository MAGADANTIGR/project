package com.example.project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "borrowed_books")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BorrowedBook {
    @Id
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "book_id")
    private Book book;
    private LocalDateTime borrowedTime;
    private LocalDateTime returnTime;
}
