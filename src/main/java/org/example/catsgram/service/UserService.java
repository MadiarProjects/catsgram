package org.example.catsgram.service;

import org.example.catsgram.exception.InvalidParam;
import org.example.catsgram.exception.NotFoundedException;
import org.example.catsgram.exception.AlreadyExistException;
import org.example.catsgram.model.User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    private final Set<User> users = new HashSet<>();

    public Set<User> getAllUsers() {
        return users;
    }
    public User getByEmil(String email){
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElseThrow(()->new NotFoundedException("пользователя с таким эмейлом не найдено"+email));
    }

    public User createUser(User user) {
        validateEmail(user.getEmail());
        if (users.contains(user)) {
            throw new AlreadyExistException("Пользователь уже существует: " + user.getEmail());
        }
        users.add(user);
        return user;
    }

    public User removeUser(User user) {
        users.remove(user);
        return user;
    }
    public User updateOrCreateUser(User user){
        validateEmail(user.getEmail());
        return removeUser(user);
    }

    private void validateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new InvalidParam("Email не может быть пустым");
        }
    }
}
