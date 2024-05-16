package com.loginspring.core.service.loginService;

import com.loginspring.core.dto.LoginDTO;
import com.loginspring.core.dto.TokenResponseDTO;

public interface LoginService {
    TokenResponseDTO login(LoginDTO login);

    TokenResponseDTO getRefreshToken(String refreshToken);
}
