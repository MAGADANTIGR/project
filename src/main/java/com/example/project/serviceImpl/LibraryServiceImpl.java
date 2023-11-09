package com.example.project.serviceImpl;

import com.example.project.models.Book;
import com.example.project.models.BorrowedBook;
import com.example.project.repository.BookRepository;
import com.example.project.repository.LibraryRepository;
import com.example.project.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAvailableBooks() {
        return bookRepository.findAvailableBooks();
    }
    public void addBook(Book book) {
        BorrowedBook borrowedBook = new BorrowedBook();
        borrowedBook.setBook(book);
        libraryRepository.save(borrowedBook);
    }

    public ResponseEntity<String> updateBook(Long id, BorrowedBook borrowedBookDetails) {
        BorrowedBook borrowedBook = libraryRepository.findById(id).orElse(null);

        if (borrowedBook != null) {
            borrowedBook.setBorrowedTime(LocalDateTime.now());
            borrowedBook.setReturnTime(borrowedBookDetails.getReturnTime());
            libraryRepository.save(borrowedBook);

            return ResponseEntity.ok(BookServiceImpl.status);
        }
        return ResponseEntity.ok("Book id not found!");
    }
}
