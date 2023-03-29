package com.demo.waterSupply.controller;

import com.demo.waterSupply.model.UtilityModel;
import com.demo.waterSupply.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/utility")
public class UtilityController {
    @Autowired
    private UtilityService utilityService;
    @PostMapping
    public UtilityModel addUtility(@RequestBody UtilityModel utilityModel) {
        return utilityService.addUtility(utilityModel);
    }
    @GetMapping("/{id}")
    public Optional<UtilityModel> getUtilityById(@PathVariable("id") int id ) {
        return utilityService.getUtilityById(id);
    }
    @PutMapping
    public UtilityModel updateUtility(@RequestBody UtilityModel utilityModel){
        return utilityService.updateUtility(utilityModel);
    }
    @DeleteMapping("/{id}")
    public String deleteUtilityById(@PathVariable("id") int id) {
        utilityService.deleteUtilityById(id);
        return "Utility got Deleted";
    }
}
