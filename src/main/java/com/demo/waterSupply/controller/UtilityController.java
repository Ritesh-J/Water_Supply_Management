package com.demo.waterSupply.controller;

import com.demo.waterSupply.model.UtilityModel;
import com.demo.waterSupply.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utility")
public class UtilityController {
    @Autowired
    private UtilityService utilityService;
    public UtilityModel addUtility(@RequestBody UtilityModel utilityModel) {
        return utilityService.addUtility(utilityModel);
    }
}
