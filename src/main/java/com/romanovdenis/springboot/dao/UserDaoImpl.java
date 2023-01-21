package com.romanovdenis.springboot.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;

import com.romanovdenis.springboot.model.User;
import jakarta.persistence.*;
import java.util.List;
@Repository
@EnableAutoConfiguration
public class UserDaoImpl implements UserDao{

    private final EntityManager entityManager;
    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAll() {
        return  (List<User>) entityManager.createQuery("from User").getResultList();

    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUser(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void updateUser(User user) {
            entityManager.merge(user);

    }
    @Override
    public User getUserId(Long id){
        return entityManager.find(User.class, id);
    }
}
