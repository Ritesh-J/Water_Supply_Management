package com.demo.waterSupply.service;

import com.demo.waterSupply.dto.request.UserRequestDTO;
import com.demo.waterSupply.dto.respond.UserRespondDTO;
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
    @Autowired
    private RoleService roleService;
    @Autowired
    private CityService cityService;
    @Autowired
    private MeterService meterService;
    public UserModel addUser(UserRequestDTO userDTO) {
//        RoleModel roleModel = roleService.getRoleById(userModel.getRoleModel().getRoleId()).get();
//        userModel.setRoleModel(roleModel);
//        CityModel cityModel=cityService.getCityById(userModel.getCityModel().getCityId()).get();
//        userModel.setCityModel(cityModel);
//        MeterModel meterModel=meterService.getMeterById(userModel.getMeterModel().getMeterId()).get();
//        userModel.setMeterModel(meterModel);
//        return userRepository.save(userModel);
        System.out.println("hii");
        UserModel userModel= new UserModel();
        userModel.setUserId(userDTO.getUserId());
        userModel.setUserName(userDTO.getUserName());
        userModel.setUserAddress(userDTO.getUserAddress());
        userModel.setUserEmail(userDTO.getUserEmail());
        CityModel city=cityRepository.findByCityName(userDTO.getCityName());
        System.out.println(city);
        userModel.setCityModel(city);
        MeterModel meter=meterRepository.findByMeterName(userDTO.getMeterName());
        userModel.setMeterModel(meter);
        RoleModel role=roleRepository.findByRoleName(userDTO.getRoleName());
        userModel.setRoleModel(role);
        return userRepository.save(userModel);

    }
    public UserModel updateUser(UserModel userModel) {
        RoleModel roleModel = roleRepository.findById(userModel.getRoleModel().getRoleId()).get();
        userModel.setRoleModel(roleModel);
        CityModel cityModel=cityRepository.findById(userModel.getCityModel().getCityId()).get();
        userModel.setCityModel(cityModel);
        MeterModel meterModel=meterRepository.findById(userModel.getMeterModel().getMeterId()).get();
        userModel.setMeterModel(meterModel);
        return userRepository.save(userModel);
    }

    public UserRespondDTO getUserById(Long userId) {
        Optional<UserModel> userModel=userRepository.findById(userId);
        if(userModel.isEmpty())
            throw  new EntityNotFoundException("Requested User Doesn't Exist");
//        if(userModel.isPresent()){
//            System.out.println(userModel.get().getRoleModel().toString());
//         RoleModel roleModel=   userModel.get().getRoleModel();
//         UserModel userModel1 = userModel.get();
//
//         userModel1.setRoleModel(roleModel);
//            return userModel1;}
//        return null;
        UserModel userModel1=userModel.get();
        UserRespondDTO userProfileDTO=new UserRespondDTO();
        userProfileDTO.setUserName(userModel1.getUserName());
        userProfileDTO.setCityName(userModel1.getCityModel().getCityName());
        userProfileDTO.setMeterName(userModel1.getMeterModel().getMeterName());
        userProfileDTO.setRoleName(userModel1.getRoleModel().getRoleName());
        return userProfileDTO;
    }
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
    public boolean existsUserEmail(UserRequestDTO userDTO) {
        if(userRepository.existsByUserEmail(userDTO.getUserEmail()))
            return true;
        return false;
    }


}
