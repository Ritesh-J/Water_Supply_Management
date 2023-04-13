package com.demo.waterSupply.controller;

import com.demo.waterSupply.model.RoleModel;
import com.demo.waterSupply.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @PostMapping
    public RoleModel addRole(@RequestBody RoleModel roleModel) {
        return roleService.addRole(roleModel);
    }
    @GetMapping("/{id}")
    public Optional<RoleModel> getRoleById(@PathVariable("id") Long id){
        return roleService.getRoleById(id);
    }
    @PutMapping
    public RoleModel updateRole(@RequestBody RoleModel roleModel) {
        return roleService.updateRole(roleModel);
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id){
         roleService.deleteRoleById(id);
        return "Role Deleted";
    }

}
