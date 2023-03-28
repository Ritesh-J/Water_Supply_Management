package com.demo.waterSupply.service;

import com.demo.waterSupply.model.UserModel;
import com.demo.waterSupply.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public UserModel addUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

}
