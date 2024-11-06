package com.loginspring.domain.service.user;

import java.util.List;

import com.loginspring.api.dto.UserDTO;
import com.loginspring.api.record.UserCreateRecord;

public interface UserService {
    UserDTO registerUser(UserCreateRecord userCreateRecord);

    List<UserDTO> findUsers(String search, String[] fields, int page, int size, String sort);
}
