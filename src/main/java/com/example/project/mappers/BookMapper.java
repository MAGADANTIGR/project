package com.example.project.mappers;

import com.example.project.dto.BookDTO;
import com.example.project.models.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
    BookDTO toDto(Book book);
    Book toEntity(BookDTO bookDTO);
}
