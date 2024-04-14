package com.loginspring.core.service.user;

import java.util.List;

import com.loginspring.core.domain.user.User;

public interface UserService {
    User registerUser(User user);

    List<User> findUsers();
}
