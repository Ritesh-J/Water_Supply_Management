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
    public String addUser(@RequestBody UserModel userModel) {
        if(userService.existsUserEmail(userModel))
            return "User already Exists";
        userService.addUser(userModel);
        return "User registered";



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
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") int userId) {
         userService.deleteUserById(userId);
         return "User Got Deleted";
    }
}
