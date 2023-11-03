package com.example.project.controller;

import com.example.project.entity.BorrowedBook;
import com.example.project.service.BookService;
import com.example.project.service.LibraryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.project.entity.Book;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@Api(tags = "Book API")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private LibraryService libraryService;

    @GetMapping
    @ApiOperation("Получение списка всех книг")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    @GetMapping("/{id}")
    @ApiOperation("Получение книги по ее id")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }
    @GetMapping("/isbn/{isbn}")
    @ApiOperation("Получение книги по ее isbn")
    public Book getBookByIsbn(@PathVariable String isbn) {
        return bookService.getBookByIsbn(isbn);
    }
    @PostMapping
    @ApiOperation("Добавление книги")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        libraryService.addBook(book);
        return bookService.addBook(book);
    }
    @DeleteMapping("/{id}")
    @ApiOperation("Удаление книги")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }
    @PutMapping("/{id}")
    @ApiOperation("Обновление информации о книге")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        return bookService.updateBook(id, bookDetails);
    }
}
