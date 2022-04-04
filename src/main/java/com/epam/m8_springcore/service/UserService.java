package com.epam.m8_springcore.service;

import com.epam.m8_springcore.dao.UserDAO;
import com.epam.m8_springcore.entity.User;
import lombok.Setter;

import java.util.List;

@Setter
public class UserService {

    private UserDAO userDAO;

    public int size() {
        return userDAO.size();
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }

    public User findById(Long id) {
        return userDAO.findById(id);
    }

    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    public User save(User user) {
        return userDAO.save(user);
    }

    public User update(User user) {
        return userDAO.update(user);
    }

    public User delete(Long id) {
        return userDAO.delete(id);
    }

    public void clear() {
        userDAO.clear();
    }
}
