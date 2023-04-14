package com.demo.waterSupply.service;

import com.demo.waterSupply.dto.request.RoleRequestDTO;
import com.demo.waterSupply.dto.respond.RoleRespondDTO;
import com.demo.waterSupply.exception.EntityExistsException;
import com.demo.waterSupply.exception.EntityNotFoundException;
import com.demo.waterSupply.model.RoleModel;
import com.demo.waterSupply.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public RoleModel addRole(RoleRequestDTO roleRequestDTO) {
        if(roleRepository.existsByRoleName(roleRequestDTO.getRoleName()))
            throw new EntityExistsException("Role Already Exists");
        RoleModel roleModel=new RoleModel();
        roleModel.setRoleName(roleRequestDTO.getRoleName());
        return roleRepository.save(roleModel);
    }
    public RoleRespondDTO getRoleById(Long id) {
        Optional<RoleModel> roleModel=roleRepository.findById(id);
        if(roleModel.isEmpty())
            throw new EntityNotFoundException("Role with this Id Doesn't Exist");
        RoleRespondDTO roleRespondDTO=new RoleRespondDTO();
        roleRespondDTO.setRoleId(roleModel.get().getRoleId());
        roleRespondDTO.setRoleName(roleModel.get().getRoleName());
        return roleRespondDTO;
    }
    public List<RoleRespondDTO> getAllRole(){
        List<RoleModel> roleModels=roleRepository.findAll();
        List<RoleRespondDTO> roleRespondDTOS=new ArrayList<>();
        if(roleModels.isEmpty())
            throw new EntityNotFoundException("Role is not Present");
        for(int i=0;i<roleModels.size();i++){
            RoleRespondDTO roleRespondDTO=new RoleRespondDTO();
            roleRespondDTO.setRoleId(roleModels.get(i).getRoleId());
            roleRespondDTO.setRoleName(roleModels.get(i).getRoleName());
            roleRespondDTOS.add(roleRespondDTO);
        }
        return roleRespondDTOS;
    }
    public void deleteRoleById(Long id){
        Optional<RoleModel> roleModel=roleRepository.findById(id);
        if(roleModel.isEmpty())
            throw new EntityNotFoundException("Role By this Id Doesn't Exist");
        roleRepository.deleteById(id);
    }
    public RoleModel updateRole(RoleRespondDTO roleRespondDTO){
        RoleModel roleModel=roleRepository.findById(roleRespondDTO.getRoleId()).get();
        roleModel.setRoleName(roleRespondDTO.getRoleName());
        return roleRepository.save(roleModel);
    }
}
