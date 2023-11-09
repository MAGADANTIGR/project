package com.example.project.controller;

import com.example.project.dto.BookDTO;
import com.example.project.dto.BorrowedBookDTO;
import com.example.project.models.Book;
import com.example.project.models.BorrowedBook;
import com.example.project.mappers.BookMapper;
import com.example.project.mappers.BorrowedBookMapper;
import com.example.project.serviceImpl.LibraryServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/library")
@Api(tags = "Library API")
public class LibraryController {
    @Autowired
    private LibraryServiceImpl libraryServiceImpl;

    @GetMapping
    @ApiOperation("Получение списка всех доступных книг")
    public List<BookDTO> getAvailableBooks() {
        List<Book> books= libraryServiceImpl.getAvailableBooks();
        return books.stream().map(BookMapper.INSTANCE::toDto).collect(Collectors.toList());
    }
    @PutMapping("/{id}")
    @ApiOperation("Обновление информации о книге")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody BorrowedBookDTO borrowedBookDTO) {
        BorrowedBook borrowedBook = BorrowedBookMapper.INSTANCE.toEntity(borrowedBookDTO);
        return libraryServiceImpl.updateBook(id, borrowedBook);
    }
}
