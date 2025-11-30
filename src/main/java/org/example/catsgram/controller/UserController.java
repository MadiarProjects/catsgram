package org.example.catsgram.controller;

import lombok.RequiredArgsConstructor;

import org.example.catsgram.exception.InvalidParam;
import org.example.catsgram.model.User;
import org.example.catsgram.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public Set<User> getUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{userEmail}")
    public User getByEmail (@PathVariable String userEmail){
        return userService.getByEmil(userEmail);
    }
    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping
    public User updateOrCreateUser(@RequestBody User user) {
        return userService.updateOrCreateUser(user);
    }

}


