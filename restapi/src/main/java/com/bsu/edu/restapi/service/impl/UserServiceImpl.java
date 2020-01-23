package com.bsu.edu.restapi.service.impl;

import com.bsu.edu.restapi.entity.User;
import com.bsu.edu.restapi.repository.UserRepository;
import com.bsu.edu.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
