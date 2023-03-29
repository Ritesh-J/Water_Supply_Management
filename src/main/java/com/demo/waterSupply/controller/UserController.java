package com.demo.waterSupply.controller;

import com.demo.waterSupply.model.UserModel;
import com.demo.waterSupply.service.UserService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public UserModel addUser(@RequestBody UserModel userModel) {
        return userService.addUser(userModel);

    }
//    @GetMapping
//    public Optional<UserModel> getUserById(@PathVariable int userId) {
//         userService.getUserById(userId);
//    }
    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable("id") int id) {

          return userService.getUserById(id);
    }
    @PutMapping
    public UserModel updateUserById(@RequestBody UserModel userModel) {
        return userService.updateUser(userModel);
    }
    @DeleteMapping
    public void deleteUserById(@PathVariable int userId) {
         userService.deleteUserById(userId);
    }
}
