package com.demo.waterSupply.service;

import com.demo.waterSupply.model.RoleModel;
import com.demo.waterSupply.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public RoleModel addRole(RoleModel roleModel) {
        return roleRepository.save(roleModel);
    }
    public Optional<RoleModel> getRoleById(int id) {
        return roleRepository.findById(id);
    }
}