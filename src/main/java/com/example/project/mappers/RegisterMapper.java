package com.example.project.mappers;

import com.example.project.dto.RegisterDto;
import com.example.project.models.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RegisterMapper {
    RegisterMapper INSTANCE = Mappers.getMapper(RegisterMapper.class);

    UserEntity toEntity(RegisterDto registerDto);
}
