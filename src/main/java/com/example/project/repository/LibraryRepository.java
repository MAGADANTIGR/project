package com.example.project.repository;

import com.example.project.entity.Book;
import com.example.project.entity.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<BorrowedBook, Long> {

}
