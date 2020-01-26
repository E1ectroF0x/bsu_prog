package com.bsu.edu.restapi.service;

import com.bsu.edu.restapi.entity.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);
    public User getUserByUsername(String username);
    public List<User> getAllUsers();
    public void deleteUserById(Long id);

}
