package com.demo.waterSupply.service;

import com.demo.waterSupply.model.CityModel;
import com.demo.waterSupply.model.UtilityModel;
import com.demo.waterSupply.repository.CityRepository;
import com.demo.waterSupply.repository.UtilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private UtilityRepository utilityRepository;
    public CityModel addCity(CityModel cityModel) {
        UtilityModel utilityModel=utilityRepository.findById(cityModel.getUtilityModel().getUtilityId()).get();
        cityModel.setUtilityModel(utilityModel);
        return cityRepository.save(cityModel);
    }
    public Optional<CityModel> getCityById(Long cityId) {
        return cityRepository.findById(cityId);
    }

    public CityModel updateCity(CityModel cityModel) {
        UtilityModel utilityModel=utilityRepository.findById(cityModel.getUtilityModel().getUtilityId()).get();
        cityModel.setUtilityModel(utilityModel);
        return cityRepository.save(cityModel);
    }
    public void deleteCityById(Long id){
        cityRepository.deleteById(id);
    }
}
