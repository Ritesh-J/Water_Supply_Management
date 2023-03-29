package com.demo.waterSupply.controller;

import com.demo.waterSupply.model.CityModel;
import com.demo.waterSupply.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;
    @PostMapping
    public CityModel addCity(@RequestBody CityModel cityModel) {
        return cityService.addCity(cityModel);
    }
    @GetMapping("/{id}")
    public Optional<CityModel> getCityById(@PathVariable("id") int id) {
        return cityService.getCityById(id);
    }

    @PutMapping()
    public CityModel updateCityById(@RequestBody CityModel cityModel) {
        return cityService.updateCity(cityModel);
    }
    @DeleteMapping("/{id}")
    public String deleteCityById(@PathVariable("id") int id) {
        cityService.deleteCityById(id);
        return "City got Deleted";
    }

}
