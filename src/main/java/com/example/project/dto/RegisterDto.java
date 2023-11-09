package com.example.project.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Класс, представляющий регистрацию пользователя")
public class RegisterDto {
    @ApiModelProperty(notes = "Имя пользователя")
    private String username;
    @ApiModelProperty(notes = "Пароль пользователя")
    private String password;
}
