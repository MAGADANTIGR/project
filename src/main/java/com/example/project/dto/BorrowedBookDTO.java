package com.example.project.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(description = "Класс, представляющий книгу, которую взяли")
public class BorrowedBookDTO {
    @ApiModelProperty(notes = "Время, когда книгу взяли")
    private LocalDateTime borrowedTime;
    @ApiModelProperty(notes = "Время, когда книгу нужно вернуть")
    private LocalDateTime returnTime;
}
