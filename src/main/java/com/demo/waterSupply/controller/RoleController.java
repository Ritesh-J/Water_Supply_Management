package com.demo.waterSupply.controller;

import com.demo.waterSupply.dto.request.RoleRequestDTO;
import com.demo.waterSupply.dto.respond.RoleRespondDTO;
import com.demo.waterSupply.model.RoleModel;
import com.demo.waterSupply.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @PostMapping
    public ResponseEntity<Object> addRole(@RequestBody RoleRequestDTO roleRequestDTO) {
        return new ResponseEntity<>(roleService.addRole(roleRequestDTO), HttpStatus.CREATED);
    }
    @GetMapping("/all-role")
    public ResponseEntity<Object> getAllRole(){
        return new ResponseEntity<>(roleService.getAllRole(), HttpStatus.FOUND);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getRoleById(@PathVariable("id") Long id){
        return new ResponseEntity<>(roleService.getRoleById(id),HttpStatus.FOUND);
    }
    @PutMapping
    public ResponseEntity<Object> updateRole(@RequestBody RoleRespondDTO roleRespondDTO) {
        return new ResponseEntity<>(roleService.updateRole(roleRespondDTO),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") Long id){
         roleService.deleteRoleById(id);
        return new ResponseEntity<>("Role Deleted", HttpStatus.OK);
    }

}
