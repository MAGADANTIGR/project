package com.example.project.repository;

import com.example.project.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByIsbn(String isbn);
    @Query("SELECT b FROM Book b WHERE b.borrowedBook.returnTime < DATE_FORMAT(NOW(), '%Y-%m-%d %H:%i:%s') OR b.borrowedBook.returnTime = null ")
    List<Book> findAvailableBooks();
}
