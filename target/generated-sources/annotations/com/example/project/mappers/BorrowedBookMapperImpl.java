package com.example.project.mappers;

import com.example.project.dto.BorrowedBookDTO;
import com.example.project.models.BorrowedBook;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-09T04:58:26+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class BorrowedBookMapperImpl implements BorrowedBookMapper {

    @Override
    public BorrowedBookDTO toDto(BorrowedBook borrowedBook) {
        if ( borrowedBook == null ) {
            return null;
        }

        BorrowedBookDTO borrowedBookDTO = new BorrowedBookDTO();

        borrowedBookDTO.setBorrowedTime( borrowedBook.getBorrowedTime() );
        borrowedBookDTO.setReturnTime( borrowedBook.getReturnTime() );

        return borrowedBookDTO;
    }

    @Override
    public BorrowedBook toEntity(BorrowedBookDTO borrowedBookDTO) {
        if ( borrowedBookDTO == null ) {
            return null;
        }

        BorrowedBook borrowedBook = new BorrowedBook();

        borrowedBook.setBorrowedTime( borrowedBookDTO.getBorrowedTime() );
        borrowedBook.setReturnTime( borrowedBookDTO.getReturnTime() );

        return borrowedBook;
    }
}
