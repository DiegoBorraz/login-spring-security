package com.loginspring.infrastructure.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.loginspring.core.domain.user.User;

@Service
public class TokenService {

    @Value("${auth.jwt.token.secret}")
    private String secretKey;
    @Value("${auth.jwt.token.expiration}")
    private int tokenExpiration;
    @Value("${auth.jwt.refersh-token.expiration}")
    private int refreshTokenExpiration;
    @Value("${auth.jwt.token.Issuer}")
    private String Inssuer;

    public String generateToken(User user, int expiration) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);

            String token = JWT.create()
                    .withIssuer(Inssuer)
                    .withSubject(user.getEmail())
                    .withExpiresAt(genExpirationDate(expiration))
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while generating token", exception);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            return JWT.require(algorithm)
                    .withIssuer(Inssuer)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTCreationException exception) {
            return "";
        }
    }

    private Instant genExpirationDate(int expiration) {
        return LocalDateTime.now().plusHours(expiration).toInstant(ZoneOffset.of("-03:00"));
    }
}