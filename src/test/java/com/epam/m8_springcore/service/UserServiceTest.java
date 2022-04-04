package com.epam.m8_springcore.service;

import com.epam.m8_springcore.ParentTestClass;
import com.epam.m8_springcore.entity.User;
import com.epam.m8_springcore.storage.UserStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserServiceTest extends ParentTestClass {

    private UserService userService;
    private UserStorage userStorage;
    private User user;

    @BeforeEach
    public void setUp() {
        userService = context.getBean("userService", UserService.class);
        userStorage = context.getBean("userStorage", UserStorage.class);

        user = new User(1L, "Misha", "misha@mail.ru");
        userStorage.saveUser(user);
    }

    @Test
    void size() {
        assertEquals(1, userService.size());
    }

    @Test
    void findAll() {
        assertEquals(List.of(user), userService.findAll());
    }

    @Test
    void findById() {
        assertEquals(user, userService.findById(user.getId()));
    }

    @Test
    void findByEmail() {
        assertEquals(user, userService.findByEmail(user.getEmail()));
    }

    @Test
    void save() {
        User newUser = new User(2L, "User", "user@mail.ru");
        assertEquals(newUser, userService.save(newUser));
    }

    @Test
    void update() {
        String newName = "Mikhail";
        User updatedUser = new User(1L, newName, "misha@mail.ru");
        assertEquals(updatedUser, userService.update(updatedUser));
    }

    @Test
    void delete() {
        assertEquals(user, userService.delete(user.getId()));
    }

    @Test
    void clear() {
        userService.clear();
        assertEquals(0, userStorage.getSizeStorage());
    }
}