package com.example.project.serviceImpl;

import com.example.project.models.Book;
import com.example.project.repository.BookRepository;
import com.example.project.repository.LibraryRepository;
import com.example.project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    protected static final String status = "OK";

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LibraryRepository libraryRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public ResponseEntity<String> addBook(Book book) {
        bookRepository.save(book);
        return ResponseEntity.ok(status);
    }

    public Book getBookById(Long id) {
        return bookRepository.getById(id);
    }
    public Book getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public ResponseEntity<String> deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if(book!=null) {
            libraryRepository.deleteById(id);
            bookRepository.deleteById(id);
            return ResponseEntity.ok(status);
        }
        return ResponseEntity.ok("Book id not found!");
    }

    public ResponseEntity<String> updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id).orElse(null);

        if (book != null) {
            book.setIsbn(bookDetails.getIsbn());
            book.setName(bookDetails.getName());
            book.setGenre(bookDetails.getGenre());
            book.setDescription(bookDetails.getDescription());
            book.setAuthor(bookDetails.getAuthor());
            bookRepository.save(book);

            return ResponseEntity.ok(status);
        }

        return ResponseEntity.ok("Book id not found!");
    }
}
