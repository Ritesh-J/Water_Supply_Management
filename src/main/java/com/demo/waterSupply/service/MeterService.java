package com.demo.waterSupply.service;

import com.demo.waterSupply.model.MeterModel;
import com.demo.waterSupply.repository.MeterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MeterService {
    @Autowired
    private MeterRepository meterRepository;
    public MeterModel addMeter(MeterModel meterModel) {
        return meterRepository.save(meterModel);
    }
    public Optional<MeterModel> getMeterById(int id){
        return meterRepository.findById(id);
    }
    public MeterModel updateMeter(MeterModel meterModel){
        return meterRepository.save(meterModel);
    }
    public void deleteById(int id){
        meterRepository.deleteById(id);
    }
}
