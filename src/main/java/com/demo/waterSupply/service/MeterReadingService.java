package com.demo.waterSupply.service;

import com.demo.waterSupply.model.MeterModel;
import com.demo.waterSupply.model.MeterReading;
import com.demo.waterSupply.repository.MeterReadingRepository;
import com.demo.waterSupply.repository.MeterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MeterReadingService {
    @Autowired
    private MeterReadingRepository meterReadingRepository;
    @Autowired
    private MeterService meterService;
    public MeterReading addReading(MeterReading meterReading) {
        MeterModel meterModel=meterService.getMeterById(meterReading.getMeterModel().getMeterId()).get();
        meterReading.setMeterModel(meterModel);
        LocalDateTime now =LocalDateTime.now();
        meterReading.setLocalDateTime(now);
        return meterReadingRepository.save(meterReading);
    }
    public MeterReading updateMeter(MeterReading meterReading) {
        MeterModel meterModel=meterService.getMeterById(meterReading.getMeterModel().getMeterId()).get();
        meterReading.setMeterModel(meterModel);
        LocalDateTime now =LocalDateTime.now();
        meterReading.setLocalDateTime(now);
        return meterReadingRepository.save(meterReading);
    }
    public Optional<MeterReading> getMeterById(int id){
        return meterReadingRepository.findById(id);
    }

    public void deleteMeterById(int id){
        meterReadingRepository.deleteById(id);
    }
}
