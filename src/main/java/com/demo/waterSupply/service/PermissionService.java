package com.demo.waterSupply.service;

import com.demo.waterSupply.model.PermissionModel;
import com.demo.waterSupply.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;
    public PermissionModel addPermission(PermissionModel permissionModel) {
        return permissionRepository.save(permissionModel);
    }
}
