package com.demo.waterSupply.controller;

import com.demo.waterSupply.dto.request.CityRequestDTO;
import com.demo.waterSupply.dto.respond.CityRespondDTO;
import com.demo.waterSupply.model.CityModel;
import com.demo.waterSupply.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;
    @PostMapping
    public ResponseEntity<Object> addCity(@RequestBody CityRequestDTO cityRequestDTO) {
        return new ResponseEntity<>(cityService.addCity(cityRequestDTO), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCityById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(cityService.getCityById(id),HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all-city")
    public ResponseEntity<Object> getAllCity(){
        return new ResponseEntity<>(cityService.getAllCity(), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Object> updateCityById(@RequestBody CityRespondDTO cityRespondDTO) {
        return new ResponseEntity<>(cityService.updateCity(cityRespondDTO), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCityById(@PathVariable("id") Long id) {
       cityService.deleteCityById(id);
       return new ResponseEntity<>("City Got Deleted", HttpStatus.OK);
    }

}
