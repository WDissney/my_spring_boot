package com.romanovdenis.springboot.dao;

import com.romanovdenis.springboot.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAll();
    void addUser(User user);
    void removeUser(Long id);
    void updateUser(User user);
    User getUserId(Long id);
}
