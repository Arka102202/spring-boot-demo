package com.springBootDemo.springbootdemoall.service;

import com.springBootDemo.springbootdemoall.entity.User;
import org.springframework.data.repository.query.Param;

public interface UserService {

    User findByFirstNameAndPassword(String firstName, String password);

    void addOrUpdateUser(User user);

    void saveUser(User user);

    void updateUserLoginStatus(int id,int status);

    User findById(int id);

}
