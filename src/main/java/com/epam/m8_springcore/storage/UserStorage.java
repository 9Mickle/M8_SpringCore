package com.epam.m8_springcore.storage;

import com.epam.m8_springcore.entity.User;
import com.epam.m8_springcore.exception.AlreadyExistException;
import com.epam.m8_springcore.exception.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Хранилище пользователей.
 */
public class UserStorage {

    private final Map<Long, User> userMap = new HashMap<>();

    public Integer getSizeStorage() {
        return userMap.size();
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    public User getUserById(Long id) {
        return userMap.values()
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
    }

    public User getUserByEmail(String email) {
        return userMap.values()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("User not found with email: " + email));
    }

    public User saveUser(User user) {
        if (userMap.values()
                .stream()
                .noneMatch(elem -> (elem.getId().equals(user.getId())
                        || elem.getEmail().equals(user.getEmail())))) {

            userMap.put(user.getId(), user);
            return user;
        } else {
            throw new AlreadyExistException("User with same id or same email already exist!");
        }
    }

    public User updateUser(User user) {
        return userMap.computeIfPresent(user.getId(), (key, value) -> value = user);
    }

    public User deleteUser(Long id) {
        return userMap.remove(id);
    }

    public void deleteAllUsers() {
        userMap.clear();
    }
}
