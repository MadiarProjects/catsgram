package org.example.catsgram.controller;

import org.example.catsgram.exception.InvalidEmailException;
import org.example.catsgram.exception.UserAlreadyExistException;
import org.example.catsgram.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Set<User> users = new HashSet<>();
    @GetMapping
    public Set<User> getUsers() {
        return users;
    }
    @PostMapping
    public User addUser(@RequestBody User user) {
        validateEmail(user.getEmail());
        if (users.contains(user)) {
            throw new UserAlreadyExistException("Пользователь уже существует: " + user.getEmail());
        }
        users.add(user);
        return user;
    }
    @PutMapping
    public User updateOrCreateUser(@RequestBody User user) {
        validateEmail(user.getEmail());
        users.remove(user);
        users.add(user);
        return user;
    }

    private void validateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new InvalidEmailException("Email не может быть пустым");
        }
    }
}


