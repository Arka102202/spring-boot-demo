package com.springBootDemo.springbootdemoall.service;

import com.springBootDemo.springbootdemoall.entity.User;
import com.springBootDemo.springbootdemoall.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;

    @Override
    @Transactional
    public User findByFirstNameAndPassword(String firstName, String password) {
        return userRepo.findByFirstNameAndPassword(firstName, password);
    }

    @Override
    @Transactional
    public void addOrUpdateUser(User user) {
        userRepo.save(user);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    @Transactional
    public void updateUserLoginStatus(int id, int status) {
        userRepo.updateUserLoginStatus(id, status);
    }

    @Override
    @Transactional
    public User findById(int id) {
        return userRepo.findById(id).get();
    }
}
