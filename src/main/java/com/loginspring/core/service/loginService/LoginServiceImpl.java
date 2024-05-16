package com.loginspring.core.service.loginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.loginspring.core.domain.user.User;
import com.loginspring.core.dto.LoginDTO;
import com.loginspring.core.dto.TokenResponseDTO;
import com.loginspring.core.repository.user.UserRepository;
import com.loginspring.infrastructure.exceptions.CustomException;
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

    public TokenResponseDTO login(LoginDTO login) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                login.email(), login.password());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        return TokenResponseDTO.builder()
                .token(tokenService.generateToken((User) authentication.getPrincipal(), tokenExpiration))
                .refreshToken(tokenService.generateToken((User) authentication.getPrincipal(), refreshTokenExpiration))
                .build();

    }

    @Override
    public TokenResponseDTO getRefreshToken(String refreshToken) {
        var email = tokenService.validateToken(refreshToken);
        UserDetails user = userRepository.findByEmail(email);
        if (user != null) {
            throw new CustomException("unauthorized user.");
        }

        var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return TokenResponseDTO.builder()
                .token(tokenService.generateToken((User) authentication.getPrincipal(), tokenExpiration))
                .refreshToken(tokenService.generateToken((User) authentication.getPrincipal(), refreshTokenExpiration))
                .build();
    }
}
