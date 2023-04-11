package com.demo.waterSupply.service;

import com.demo.waterSupply.model.UtilityModel;
import com.demo.waterSupply.repository.UtilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilityService {
    @Autowired
    private UtilityRepository utilityRepository;
    public UtilityModel addUtility(UtilityModel utilityModel) {
        return utilityRepository.save(utilityModel);
    }
    public Optional<UtilityModel> getUtilityById(int id) {
        return utilityRepository.findById(id);
    }
    public UtilityModel updateUtility(UtilityModel utilityModel) {
        return utilityRepository.save(utilityModel);
    }
    public void deleteUtilityById(int id) {
        utilityRepository.deleteById(id);
    }
    public List<UtilityModel> addAllUtility(List<UtilityModel> utilityModels){
        return utilityRepository.saveAll(utilityModels);
    }
}
