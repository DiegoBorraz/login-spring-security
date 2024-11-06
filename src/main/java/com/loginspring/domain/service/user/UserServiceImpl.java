package com.loginspring.domain.service.user;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.loginspring.api.specification.UserSpecification;
import com.loginspring.api.dto.UserDTO;
import com.loginspring.api.record.UserCreateRecord;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.loginspring.domain.entity.User;
import com.loginspring.domain.repository.user.UserRepository;
import com.loginspring.api.exceptions.CustomException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO registerUser(UserCreateRecord userCreateRecord) {
        UserDetails userExist = userRepository.findByEmail(userCreateRecord.email());
        if (userExist != null) {
            throw new CustomException("Email already exists.");
        }
        User user = new User();
        user.setName(userCreateRecord.name());
        user.setEmail(userCreateRecord.email());
        user.setPassword(passwordEncoder().encode(userCreateRecord.password()));
        user.setCreatedDate(LocalDateTime.now());
        User newUser = userRepository.save(user);
        return modelMapper.map(newUser, UserDTO.class);
    }

    @Override
    public List<UserDTO> findUsers(String search, String[] fields, int page, int size, String sort) {
        if (!search.isEmpty() && fields != null) {
            Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
            UserSpecification userSpecification = new UserSpecification(search,fields);
            Page<User> userPage = userRepository.findAll(userSpecification, pageable);
            return userPage.getContent().stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
        }
        return userRepository.findAll().stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
