package com.loginspring.core.repository.user;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.loginspring.core.domain.user.User;

public interface UserRepository extends CrudRepository<User, UUID> {

    UserDetails findByEmail(String email);

    // List<User> findAll();
}
