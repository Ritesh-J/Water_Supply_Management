package com.demo.waterSupply.controller;

import com.demo.waterSupply.model.UserModel;
import com.demo.waterSupply.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public UserModel addUser(@RequestBody UserModel userModel) {
        return userService.addUser(userModel);

    }
}
