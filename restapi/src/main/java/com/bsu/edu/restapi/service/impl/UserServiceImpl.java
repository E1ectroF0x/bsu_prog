package com.bsu.edu.restapi.service.impl;

import com.bsu.edu.restapi.entity.User;
import com.bsu.edu.restapi.repository.UserRepository;
import com.bsu.edu.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        user.setAuth_key("");
        return userRepository.save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        List<User> users = (List<User>) userRepository.findAll();
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
