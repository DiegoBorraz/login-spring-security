package com.loginspring.domain.service.loginService;

import com.loginspring.api.record.LoginRecord;
import com.loginspring.api.record.TokenResponseRecord;

public interface LoginService {
    TokenResponseRecord login(LoginRecord login);

    TokenResponseRecord getRefreshToken(String refreshToken);
}
