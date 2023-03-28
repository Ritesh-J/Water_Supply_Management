package com.demo.waterSupply.service;

import com.demo.waterSupply.model.UtilityModel;
import com.demo.waterSupply.repository.UtilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilityService {
    @Autowired
    private UtilityRepository utilityRepository;
    public UtilityModel addUtility(UtilityModel utilityModel) {
        return utilityRepository.save(utilityModel);
    }
}
