package com.epam.m8_springcore.dao;

import com.epam.m8_springcore.entity.User;
import com.epam.m8_springcore.storage.UserStorage;
import lombok.Setter;

import java.util.List;

/**
 * Слой доступа к хранилищу пользователей.
 */
@Setter
public class UserDAO {

    private UserStorage userStorage;

    public int size() {
        return userStorage.getSizeStorage();
    }

    public List<User> findAll() {
        return userStorage.getAllUsers();
    }

    public User findById(Long id) {
        return userStorage.getUserById(id);
    }

    public User findByEmail(String email) {
        return userStorage.getUserByEmail(email);
    }

    public User save(User User) {
        return userStorage.saveUser(User);
    }

    public User update(User User) {
        return userStorage.updateUser(User);
    }

    public User delete(Long id) {
        return userStorage.deleteUser(id);
    }

    public void clear() {
        userStorage.deleteAllUsers();
    }
}
