package com.demo.waterSupply.service;

import com.demo.waterSupply.model.RoleModel;
import com.demo.waterSupply.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public RoleModel addRole(RoleModel roleModel) {
        return roleRepository.save(roleModel);
    }
}
