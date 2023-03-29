package com.demo.waterSupply.service;

import com.demo.waterSupply.model.RoleModel;
import com.demo.waterSupply.model.UserModel;
import com.demo.waterSupply.repository.RoleRepository;
import com.demo.waterSupply.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;
    public UserModel addUser(UserModel userModel) {
        RoleModel roleModel = roleService.getRoleById(userModel.getRoleModel().getRoleId()).get();
        userModel.setRoleModel(roleModel);
        return userRepository.save(userModel);
    }
    public UserModel updateUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public UserModel getUserById(int userId) {
        Optional<UserModel> userModel=userRepository.findById(userId);
//        if(userModel.isPresent()){
//            System.out.println(userModel.get().getRoleModel().toString());
//         RoleModel roleModel=   userModel.get().getRoleModel();
         UserModel userModel1 = userModel.get();
//
//         userModel1.setRoleModel(roleModel);
//            return userModel1;}
//        return null;
        return userModel1;
    }
    public void deleteUserById(int userId) {
        userRepository.deleteById(userId);
    }

}
