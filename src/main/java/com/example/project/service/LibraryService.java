package com.example.project.service;

import com.example.project.entity.Book;
import com.example.project.entity.BorrowedBook;
import com.example.project.repository.BookRepository;
import com.example.project.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAvailableBooks() {
        return bookRepository.findAvailableBooks();
    }
    public void addBook(@RequestBody Book book) {
        BorrowedBook borrowedBook = new BorrowedBook();
        borrowedBook.setBook(book);
        libraryRepository.save(borrowedBook);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody BorrowedBook borrowedBookDetails) {
        BorrowedBook borrowedBook = libraryRepository.findById(id).orElse(null);

        if (borrowedBook != null) {
            borrowedBook.setBorrowedTime(borrowedBookDetails.getBorrowedTime());
            borrowedBook.setReturnTime(borrowedBookDetails.getReturnTime());
            libraryRepository.save(borrowedBook);

            return ResponseEntity.ok("OK");
        }

        return null;
    }
}
