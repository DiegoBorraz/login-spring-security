package com.loginspring.core.service.loginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.loginspring.core.domain.user.User;
import com.loginspring.core.recordClass.LoginRecord;
import com.loginspring.infrastructure.security.TokenService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public String login(LoginRecord login) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                login.email(), login.password());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        return tokenService.generateToken((User) authentication.getPrincipal());
    }
}
