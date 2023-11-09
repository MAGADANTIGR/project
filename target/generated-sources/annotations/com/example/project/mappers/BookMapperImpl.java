package com.example.project.mappers;

import com.example.project.dto.BookDTO;
import com.example.project.models.Book;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-09T04:58:26+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDTO toDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        bookDTO.setIsbn( book.getIsbn() );
        bookDTO.setName( book.getName() );
        bookDTO.setGenre( book.getGenre() );
        bookDTO.setDescription( book.getDescription() );
        bookDTO.setAuthor( book.getAuthor() );

        return bookDTO;
    }

    @Override
    public Book toEntity(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setIsbn( bookDTO.getIsbn() );
        book.setName( bookDTO.getName() );
        book.setGenre( bookDTO.getGenre() );
        book.setDescription( bookDTO.getDescription() );
        book.setAuthor( bookDTO.getAuthor() );

        return book;
    }
}
