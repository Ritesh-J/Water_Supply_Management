package com.demo.waterSupply.controller;

import com.demo.waterSupply.dto.request.UserRequestDTO;
import com.demo.waterSupply.dto.respond.UserRespondDTO;
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
    public ResponseEntity<Object> addUser(@RequestBody UserRequestDTO userRequestDTO){
        return new ResponseEntity<>(userService.addUser(userRequestDTO),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
          return ResponseEntity.ok(userService.getUserById(id));
    }
    @GetMapping("/all-users")
    public ResponseEntity<Object> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<UserModel> updateUserById(@RequestBody UserRespondDTO userRespondDTO) {
        return new ResponseEntity<>(userService.updateUser(userRespondDTO), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Long userId) {
         userService.deleteUserById(userId);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
