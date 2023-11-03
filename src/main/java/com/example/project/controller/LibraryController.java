package com.example.project.controller;

import com.example.project.entity.Book;
import com.example.project.entity.BorrowedBook;
import com.example.project.service.LibraryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
@Api(tags = "Library API")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping
    @ApiOperation("Получение списка всех доступных книг")
    public List<Book> getAvailableBooks() {
        return libraryService.getAvailableBooks();
    }
    @PutMapping("/{id}")
    @ApiOperation("Обновление информации о книге")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody BorrowedBook borrowedBook) {
        return libraryService.updateBook(id, borrowedBook);
    }
}
