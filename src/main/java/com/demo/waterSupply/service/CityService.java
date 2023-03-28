package com.demo.waterSupply.service;

import com.demo.waterSupply.model.CityModel;
import com.demo.waterSupply.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;
    public CityModel addCity(CityModel cityModel) {
        return cityRepository.save(cityModel);
    }
}
