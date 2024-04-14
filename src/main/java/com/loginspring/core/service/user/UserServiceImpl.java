package com.loginspring.core.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.loginspring.core.domain.user.User;
import com.loginspring.core.repository.user.UserRepository;
import com.loginspring.infrastructure.exceptions.CustomException;
import com.loginspring.util.ListConverter;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        UserDetails userExist = userRepository.findByEmail(user.getEmail());
        if (userExist != null) {
            throw new CustomException("Email already exists.");
        }
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        User newUser = userRepository.save(user);
        return newUser;
    }

    @Override
    public List<User> findUsers() {
        List<User> userList = ListConverter.toList(userRepository.findAll());
        return userList;
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
