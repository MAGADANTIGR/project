package com.example.project.controller;

import com.example.project.dto.BookDTO;
import com.example.project.mappers.BookMapper;
import com.example.project.models.Book;
import com.example.project.serviceImpl.BookServiceImpl;
import com.example.project.serviceImpl.LibraryServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
@Api(tags = "Book API")
public class BookController {
    @Autowired
    private BookServiceImpl bookServiceImpl;
    @Autowired
    private LibraryServiceImpl libraryServiceImpl;

    @GetMapping
    @ApiOperation("Получение списка всех книг")
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookServiceImpl.getAllBooks();
        return books.stream().map(BookMapper.INSTANCE::toDto).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    @ApiOperation("Получение книги по ее id")
    public BookDTO getBookById(@PathVariable Long id) {
        Book book = bookServiceImpl.getBookById(id);
        return BookMapper.INSTANCE.toDto(book);
    }
    @GetMapping("/isbn/{isbn}")
    @ApiOperation("Получение книги по ее isbn")
    public BookDTO getBookByIsbn(@PathVariable String isbn) {
        Book book = bookServiceImpl.getBookByIsbn(isbn);
        return BookMapper.INSTANCE.toDto(book);
    }
    @PostMapping
    @ApiOperation("Добавление книги")
    public ResponseEntity<String> addBook(@RequestBody BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.toEntity(bookDTO);
        libraryServiceImpl.addBook(book);
        return bookServiceImpl.addBook(book);
    }
    @DeleteMapping("/{id}")
    @ApiOperation("Удаление книги")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        return bookServiceImpl.deleteBook(id);
    }
    @PutMapping("/{id}")
    @ApiOperation("Обновление информации о книге")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDetails) {
        Book book = BookMapper.INSTANCE.toEntity(bookDetails);
        return bookServiceImpl.updateBook(id, book);
    }
}
