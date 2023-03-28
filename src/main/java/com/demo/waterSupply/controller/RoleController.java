package com.demo.waterSupply.controller;

import com.demo.waterSupply.model.RoleModel;
import com.demo.waterSupply.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @PostMapping
    public RoleModel addRole(@RequestBody RoleModel roleModel) {
        return roleService.addRole(roleModel);
    }

}
