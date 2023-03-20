package com.example.userservice.controller;

import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    /**
     * Creates of a user account
     * @param user User to create
     * @return JSON with user properties
     */
    @PostMapping("/create")
    public User create(@RequestBody @Valid User user) {
        return userService.saveUser(user);
    }

    /**
     * Get user by user id
     * @param  id User id
     * @return User if id is valid. Null if requested user id is not exists.
     */
    @GetMapping("/{id}")
    public Optional<User> byUserId(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    /**
     * Get user by email
     * @param email User email
     * @return User if email has been found. Null if requested email is not exists.
     */
    @GetMapping("/email/{email}")
    public Optional<User> byUserEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }
}
