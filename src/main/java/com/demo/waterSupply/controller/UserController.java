package com.demo.waterSupply.controller;

import com.demo.waterSupply.dto.request.UserRequestDTO;
import com.demo.waterSupply.model.UserModel;
import com.demo.waterSupply.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody @Valid UserRequestDTO userDTO) {
//        if(userService.existsUserEmail(userDTO))
//        return new ResponseEntity<>(userService.addUser(userDTO), HttpStatus.CREATED);
//        else
        System.out.println("hii");
            userService.addUser(userDTO);
            return new ResponseEntity<>("user Exist", HttpStatus.CREATED);
//        if(userService.existsUserEmail(userModel))
////            return "User already Exists";
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        return new ResponseEntity<>(userService.addUser(userModel),HttpStatus.CREATED);
    }

//    @GetMapping
//    public Optional<UserModel> getUserById(@PathVariable int userId) {
//         userService.getUserById(userId);
//    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {

          return ResponseEntity.ok(userService.getUserById(id));
    }
    @PutMapping
    public ResponseEntity<UserModel> updateUserById(@RequestBody UserModel userModel) {
        return new ResponseEntity<>(userService.updateUser(userModel), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Long userId) {
         userService.deleteUserById(userId);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
