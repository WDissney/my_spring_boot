package com.romanovdenis.springboot.service;


import com.romanovdenis.springboot.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void addUser(User user);
    void removeUser(Long id);
//    void updateUser(User user);
    User getUserId(Long id);
}
