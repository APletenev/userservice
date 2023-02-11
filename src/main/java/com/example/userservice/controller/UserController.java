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

    @PostMapping("/create")
    public User create(@RequestBody @Valid User user) {
        return userService.saveUser(user);
    }
    @GetMapping("/{id}")
    public Optional<User> byUserId(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
