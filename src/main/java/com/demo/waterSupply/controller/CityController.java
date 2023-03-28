package com.demo.waterSupply.controller;

import com.demo.waterSupply.model.CityModel;
import com.demo.waterSupply.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;
    @PostMapping
    public CityModel addCity(@RequestBody CityModel cityModel) {
        return cityService.addCity(cityModel);
    }
}
