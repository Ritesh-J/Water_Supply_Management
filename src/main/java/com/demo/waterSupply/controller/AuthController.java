package com.demo.waterSupply.controller;

import com.demo.waterSupply.dto.respond.UserRespondDTO;
import com.demo.waterSupply.jwtUtils.JwtUtils;
import com.demo.waterSupply.model.UserModel;
import com.demo.waterSupply.repository.UserRepository;
import com.demo.waterSupply.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/api/get-email")
    public ResponseEntity<Object> getEmailFromToken(@RequestHeader("Authorization") String authHeader, HttpServletResponse response) throws IOException {
        String jwt = authHeader.replace("Bearer ", "");
        String emailToVerify= JwtUtils.getEmailFromJwt(jwt);

//        UserRespondDTO userRespondDTO=new UserRespondDTO();
//        UserModel userModel=userRepository.findByUserEmail(emailToVerify);
//        userRespondDTO.setUserName(userModel.getUserName());
//        userRespondDTO.setUserEmail(userModel.getUserEmail());
//        userRespondDTO.setRoleName(userModel.getRoleModel().getRoleName());
//        userRespondDTO.setCityName(userModel.getCityModel().getCityName());
//        userRespondDTO.setUserAddress(userModel.getUserAddress());
//        userRespondDTO.setMeterName(userModel.getMeterModel().getMeterName());
//        userRespondDTO.setUserId(userModel.getUserId());
        return new ResponseEntity<>(userService.loginVerification(emailToVerify), HttpStatus.OK);
    }
}
