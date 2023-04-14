package com.demo.waterSupply.controller;

import com.demo.waterSupply.dto.request.UtilityRequestDTO;
import com.demo.waterSupply.model.UtilityModel;
import com.demo.waterSupply.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utility")
public class UtilityController {
    @Autowired
    private UtilityService utilityService;
    @PostMapping
    public ResponseEntity<Object> addUtility(@RequestBody UtilityRequestDTO utilityRequestDTO) {
        return new ResponseEntity<>(utilityService.addUtility(utilityRequestDTO), HttpStatus.CREATED);
    }
    @PostMapping("/all-utility")
    public ResponseEntity<Object> addAllUtility(@RequestBody List<UtilityRequestDTO> utilityRequestDTOS){
        return new ResponseEntity<>(utilityService.addAllUtility(utilityRequestDTOS), HttpStatus.CREATED);
    }
    @GetMapping("/all-utility")
    public ResponseEntity<Object> getAllUtility(){
        return new ResponseEntity<>(utilityService.getAllUtility(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUtilityById(@PathVariable("id") Long id ) {
        return new ResponseEntity<>(utilityService.getUtilityById(id), HttpStatus.FOUND);
    }
    @PutMapping
    public ResponseEntity<Object> updateUtility(@RequestBody UtilityModel utilityModel){
        return new ResponseEntity<>(utilityService.updateUtility(utilityModel), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUtilityById(@PathVariable("id") Long id) {
        utilityService.deleteUtilityById(id);
        return new ResponseEntity<>("Utility Got Deleted", HttpStatus.OK);
    }
}
