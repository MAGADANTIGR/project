package com.example.project.mappers;

import com.example.project.dto.BorrowedBookDTO;
import com.example.project.models.BorrowedBook;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BorrowedBookMapper {
    BorrowedBookMapper INSTANCE = Mappers.getMapper(BorrowedBookMapper.class);
    BorrowedBookDTO toDto(BorrowedBook borrowedBook);
    BorrowedBook toEntity(BorrowedBookDTO borrowedBookDTO);
}
