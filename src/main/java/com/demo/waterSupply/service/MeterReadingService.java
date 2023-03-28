package com.demo.waterSupply.service;

import com.demo.waterSupply.model.MeterReading;
import com.demo.waterSupply.repository.MeterReadingRepository;
import com.demo.waterSupply.repository.MeterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeterReadingService {
    @Autowired
    private MeterReadingRepository meterReadingRepository;
    public MeterReading addReading(MeterReading meterReading) {
        return meterReadingRepository.save(meterReading);
    }
}
