package com.demo.waterSupply.controller;

import com.demo.waterSupply.model.PermissionModel;
import com.demo.waterSupply.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @PostMapping
    public PermissionModel addUser(@RequestBody PermissionModel permissionModel) {
        return permissionService.addPermission(permissionModel);
    }
}
