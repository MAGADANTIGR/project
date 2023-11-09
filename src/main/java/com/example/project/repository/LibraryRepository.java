package com.example.project.repository;

import com.example.project.models.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<BorrowedBook, Long> {

}
