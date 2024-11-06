package com.loginspring.controller.user;

import java.util.List;

import com.loginspring.api.dto.UserDTO;
import com.loginspring.api.record.UserCreateRecord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.loginspring.domain.service.user.UserServiceImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;


    @PostMapping("/register")
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserCreateRecord userCreateRecord) {
        UserDTO userDTO  = userService.registerUser(userCreateRecord);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> findAllUsers(@RequestParam(value = "q", required = false) String search, @RequestParam(value = "fields", required = false) String[] fields, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "100") int size, @RequestParam(defaultValue = "name") String sort) {
        List<UserDTO> users = userService.findUsers(search, fields, page, size, sort);
        return ResponseEntity.ok(users);
    }

}