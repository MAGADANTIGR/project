package com.example.project.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Класс, представляющий токен для аутентификации пользователя")
public class AuthResponseDTO {
    @ApiModelProperty(notes = "Токен")
    private String accessToken;
    @ApiModelProperty(notes = "Тип токена")
    private String tokenType = "Bearer ";

    public AuthResponseDTO(String accessToken) {
        this.accessToken = accessToken;
    }
}
