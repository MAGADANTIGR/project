package com.example.project.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@ApiModel(description = "Класс, представляющий книгу")
public class BookDTO {
    @ApiModelProperty(notes = "ISBN книги")
    private String isbn;
    @ApiModelProperty(notes = "Название книги")
    private String name;
    @ApiModelProperty(notes = "Жанр книги")
    private String genre;
    @ApiModelProperty(notes = "Описание книги")
    private String description;
    @ApiModelProperty(notes = "Автор книги")
    private String author;
}
