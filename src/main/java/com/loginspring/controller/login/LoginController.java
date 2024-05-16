package com.loginspring.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.loginspring.core.dto.LoginDTO;
import com.loginspring.core.dto.TokenResponseDTO;
import com.loginspring.core.service.loginService.LoginServiceImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LoginController {

    @Autowired
    LoginServiceImpl loginService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponseDTO login(@RequestBody @Valid LoginDTO login) {
        return loginService.login(login);
    }

    @PostMapping("refresh-token")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponseDTO refreshToken(@RequestBody @Valid String requestRefreshToken) {
        return loginService.getRefreshToken(requestRefreshToken);
    }
}
