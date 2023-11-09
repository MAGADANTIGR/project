package com.example.project.mappers;

import com.example.project.dto.RegisterDto;
import com.example.project.models.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-09T04:58:26+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class RegisterMapperImpl implements RegisterMapper {

    @Override
    public UserEntity toEntity(RegisterDto registerDto) {
        if ( registerDto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUsername( registerDto.getUsername() );
        userEntity.setPassword( registerDto.getPassword() );

        return userEntity;
    }
}
