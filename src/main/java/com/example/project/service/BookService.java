package com.example.project.service;

import com.example.project.models.Book;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book getBookByIsbn(String isbn);
    ResponseEntity<String> addBook(Book book);
    ResponseEntity<String> updateBook(Long id, Book newBook);
    ResponseEntity<String> deleteBook(Long id);
}
