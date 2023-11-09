package com.example.project.service;

import com.example.project.models.Book;
import com.example.project.models.BorrowedBook;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LibraryService {
    List<Book> getAvailableBooks();
    void addBook(Book book);
    ResponseEntity<String> updateBook(Long id,BorrowedBook borrowedBookDetails);
}
