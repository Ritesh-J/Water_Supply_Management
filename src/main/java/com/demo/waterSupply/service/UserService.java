package com.demo.waterSupply.service;

import com.demo.waterSupply.dto.request.MeterRequestDTO;
import com.demo.waterSupply.dto.request.UserRequestDTO;
import com.demo.waterSupply.dto.respond.RoleRespondDTO;
import com.demo.waterSupply.dto.respond.UserRespondDTO;
import com.demo.waterSupply.exception.EntityExistsException;
import com.demo.waterSupply.exception.EntityNotFoundException;
import com.demo.waterSupply.model.CityModel;
import com.demo.waterSupply.model.MeterModel;
import com.demo.waterSupply.model.RoleModel;
import com.demo.waterSupply.model.UserModel;
import com.demo.waterSupply.repository.CityRepository;
import com.demo.waterSupply.repository.MeterRepository;
import com.demo.waterSupply.repository.RoleRepository;
import com.demo.waterSupply.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MeterRepository meterRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private CityRepository cityRepository;
    public UserModel addUser(UserRequestDTO userDTO) {
        UserModel userModel=new UserModel();
        if(!cityRepository.existsByCityName(userDTO.getCityName()))
            throw new EntityNotFoundException("City Doesn't Exists");
        CityModel cityModel=cityRepository.findByCityName(userDTO.getCityName());
        if(!meterRepository.existsByMeterName(userDTO.getMeterName()))
            throw new EntityNotFoundException("Meter Doesn't Exists");
        MeterModel meterModel=meterRepository.findByMeterName(userDTO.getMeterName());
        if(!roleRepository.existsByRoleName(userDTO.getRoleName()))
            throw new EntityNotFoundException("Role Doesn't Exists");
        RoleModel roleModel=roleRepository.findByRoleName(userDTO.getRoleName());
        if(userRepository.existsByUserEmail(userDTO.getUserEmail()))
            throw new EntityExistsException("User Already Exists");
        userModel.setUserName(userDTO.getUserName());
        userModel.setUserEmail(userDTO.getUserEmail());
        userModel.setUserAddress(userDTO.getUserAddress());
        userModel.setRoleModel(roleModel);
        userModel.setMeterModel(meterModel);
        userModel.setCityModel(cityModel);
        return userRepository.save(userModel);
    }
    public UserModel updateUser(UserRespondDTO userRespondDTO){
        UserModel userModel=userRepository.findById(userRespondDTO.getUserId()).get();
        if(!cityRepository.existsByCityName(userRespondDTO.getCityName()))
            throw new EntityNotFoundException("City Doesn't Exists");
        CityModel cityModel=cityRepository.findByCityName(userRespondDTO.getCityName());
        if(!meterRepository.existsByMeterName(userRespondDTO.getMeterName()))
            throw new EntityNotFoundException("Meter Doesn't Exists");
        MeterModel meterModel=meterRepository.findByMeterName(userRespondDTO.getMeterName());
        if(!roleRepository.existsByRoleName(userRespondDTO.getRoleName()))
            throw new EntityNotFoundException("Role Doesn't Exists");
        RoleModel roleModel=roleRepository.findByRoleName(userRespondDTO.getRoleName());
        userModel.setUserName(userRespondDTO.getUserName());
        userModel.setUserEmail(userRespondDTO.getUserEmail());
        userModel.setUserAddress(userRespondDTO.getUserAddress());
        userModel.setRoleModel(roleModel);
        userModel.setMeterModel(meterModel);
        userModel.setCityModel(cityModel);
        return userRepository.save(userModel);
    }

    public UserRespondDTO getUserById(Long userId) {
        Optional<UserModel> userModel=userRepository.findById(userId);
        if(userModel.isEmpty())
            throw new EntityNotFoundException("User With this id Doesn't Exists");
        UserRespondDTO userRespondDTO=new UserRespondDTO();
        userRespondDTO.setUserId(userModel.get().getUserId());
        userRespondDTO.setUserName(userModel.get().getUserName());
        userRespondDTO.setUserAddress(userModel.get().getUserAddress());
        userRespondDTO.setUserEmail(userModel.get().getUserEmail());
        userRespondDTO.setCityName(userModel.get().getCityModel().getCityName());
        userRespondDTO.setMeterName(userModel.get().getMeterModel().getMeterName());
        userRespondDTO.setRoleName(userModel.get().getRoleModel().getRoleName());
        return userRespondDTO;
    }
    public List<UserRespondDTO> getAllUsers(){
        List<UserModel>userModels=userRepository.findAll();
        if(userModels.isEmpty())
            throw new EntityNotFoundException("No users Exists");
        List<UserRespondDTO> userRespondDTOS=new ArrayList<>();
        for(int i=0;i<userModels.size();i++){
            UserRespondDTO userRespondDTO=new UserRespondDTO();
            userRespondDTO.setUserId(userModels.get(i).getUserId());
            userRespondDTO.setUserName(userModels.get(i).getUserName());
            userRespondDTO.setUserEmail(userModels.get(i).getUserEmail());
            userRespondDTO.setUserAddress(userModels.get(i).getUserAddress());
            userRespondDTO.setMeterName(userModels.get(i).getMeterModel().getMeterName());
            userRespondDTO.setCityName(userModels.get(i).getCityModel().getCityName());
            userRespondDTO.setRoleName(userModels.get(i).getRoleModel().getRoleName());
            userRespondDTOS.add(userRespondDTO);
        }
        return userRespondDTOS;
    }
    public void deleteUserById(Long userId) {
        Optional<UserModel> userModel=userRepository.findById(userId);
        if(userModel.isEmpty())
            throw new EntityNotFoundException("User Doesn't Exists By this Id");
        userRepository.deleteById(userId);
    }

    public UserRespondDTO loginVerification(String email){
        UserRespondDTO userRespondDTO=new UserRespondDTO();
        UserModel userModel=userRepository.findByUserEmail(email);
        if(userModel==null)
            throw new EntityNotFoundException("User Doesn't Exists");
        userRespondDTO.setUserName(userModel.getUserName());
        userRespondDTO.setUserEmail(userModel.getUserEmail());
        userRespondDTO.setRoleName(userModel.getRoleModel().getRoleName());
        userRespondDTO.setCityName(userModel.getCityModel().getCityName());
        userRespondDTO.setUserAddress(userModel.getUserAddress());
        userRespondDTO.setMeterName(userModel.getMeterModel().getMeterName());
        userRespondDTO.setUserId(userModel.getUserId());
        return userRespondDTO;
    }



}
