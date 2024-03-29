package com.example.userservice.service;

import com.example.userservice.entity.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> getUserById(Long userId);

    Optional<User> getUserByEmail(String userEmail);
}
