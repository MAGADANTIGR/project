package com.example.project.service;

import com.example.project.entity.Book;
import com.example.project.entity.BorrowedBook;
import com.example.project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        bookRepository.save(book);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.getById(id);
    }
    @GetMapping("/isbn/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return ResponseEntity.ok("OK");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book book = bookRepository.findById(id).orElse(null);

        if (book != null) {
            book.setIsbn(bookDetails.getIsbn());
            book.setName(bookDetails.getName());
            book.setGenre(bookDetails.getGenre());
            book.setDescription(bookDetails.getDescription());
            book.setAuthor(bookDetails.getAuthor());
            bookRepository.save(book);

            return ResponseEntity.ok("OK");
        }

        return null;
    }
}
