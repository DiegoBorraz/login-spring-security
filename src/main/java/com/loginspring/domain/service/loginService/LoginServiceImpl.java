package com.loginspring.domain.service.loginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.loginspring.domain.entity.User;
import com.loginspring.api.record.LoginRecord;
import com.loginspring.api.record.TokenResponseRecord;
import com.loginspring.domain.repository.user.UserRepository;
import com.loginspring.api.exceptions.CustomException;
import com.loginspring.infrastructure.security.TokenService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Value("${auth.jwt.token.expiration}")
    private int tokenExpiration;

    @Value("${auth.jwt.refersh-token.expiration}")
    private int refreshTokenExpiration;

    @Autowired
    private TokenService tokenService;

    @Autowired
    UserRepository userRepository;

    public TokenResponseRecord login(LoginRecord login) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                login.email(), login.password());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        return TokenResponseRecord.builder()
                .token(tokenService.generateToken((User) authentication.getPrincipal(), tokenExpiration))
                .refreshToken(tokenService.generateToken((User) authentication.getPrincipal(), refreshTokenExpiration))
                .build();

    }

    @Override
    public TokenResponseRecord getRefreshToken(String refreshToken) {
        var email = tokenService.validateToken(refreshToken);
        UserDetails user = userRepository.findByEmail(email);
        if (user != null) {
            throw new CustomException("unauthorized user.");
        }

        var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return TokenResponseRecord.builder()
                .token(tokenService.generateToken((User) authentication.getPrincipal(), tokenExpiration))
                .refreshToken(tokenService.generateToken((User) authentication.getPrincipal(), refreshTokenExpiration))
                .build();
    }
}
