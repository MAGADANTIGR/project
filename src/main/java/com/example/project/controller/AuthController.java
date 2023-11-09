package com.example.project.controller;

import com.example.project.dto.AuthResponseDTO;
import com.example.project.dto.LoginDto;
import com.example.project.dto.RegisterDto;
import com.example.project.models.UserEntity;
import com.example.project.mappers.RegisterMapper;
import com.example.project.security.CustomUserDetailsService;
import com.example.project.security.JWTGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Api(tags = "Auth API")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private JWTGenerator jwtGenerator;
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JWTGenerator jwtGenerator,
                          CustomUserDetailsService customUserDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtGenerator = jwtGenerator;
        this.customUserDetailsService = customUserDetailsService;
    }

    @PostMapping("/login")
    @ApiOperation("Авторизация пользователя")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(),
                loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }

    @PostMapping("/register")
    @ApiOperation("Регистрация пользователя")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        UserEntity userEntity = RegisterMapper.INSTANCE.toEntity(registerDto);
        if (customUserDetailsService.findByUsername(userEntity.getUsername())) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        return customUserDetailsService.register(userEntity);
    }
}
