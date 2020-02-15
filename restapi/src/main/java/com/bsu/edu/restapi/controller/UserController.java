package com.bsu.edu.restapi.controller;

import com.bsu.edu.restapi.entity.User;
import com.bsu.edu.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void save(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping(value = "/all")
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/current")
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // todo exclude password from model!
        return userService.getUserByUsername(((org.springframework.security.core.userdetails.User) authentication.getPrincipal()).getUsername());
    }

}
