package com.romanovdenis.springboot.service;

import com.romanovdenis.springboot.dao.UserDao;
import com.romanovdenis.springboot.model.User;
import com.romanovdenis.springboot.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    public final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @Override
    public void removeUser(Long id){
        userRepository.deleteById(id);
    }
    @Override
    public void addUser(User user){
        userRepository.save(user);
    }
    @Override
    public User getUserId(Long id){
       return userRepository.getReferenceById(id);
    }
//    @Override
//    @Transactional
//    public void updateUser(User user){
//        userRepository.saveUser
//    }
}
