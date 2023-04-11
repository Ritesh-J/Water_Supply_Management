package com.demo.waterSupply.service;

import com.demo.waterSupply.model.MeterModel;
import com.demo.waterSupply.model.MeterReading;
import com.demo.waterSupply.model.WaterMeterMapping;
import com.demo.waterSupply.repository.MeterReadingRepository;
import com.demo.waterSupply.repository.MeterRepository;
import com.demo.waterSupply.repository.WaterMeterMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MeterReadingService {
    @Autowired
    private MeterReadingRepository meterReadingRepository;
    @Autowired
    private MeterService meterService;
    @Autowired
    private WaterMeterMappingRepository waterMeterMappingRepository;
    public MeterReading addReading(MeterReading meterReading) {
        MeterModel meterModel=meterService.getMeterById(meterReading.getMeterModel().getMeterId()).get();
        meterReading.setMeterModel(meterModel);
        meterReading.setExpectedVolume(calculateExpectedVolume(meterReading));
        meterReading.setPercentageLossOfWater(meterReading.getExpectedVolume()-meterReading.getMeterReading());
        LocalDateTime now =LocalDateTime.now();
        meterReading.setLocalDateTime(now);
//        System.out.println(calculateExpectedVolume(meterReading));
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
    public int calculateExpectedVolume(MeterReading meterReading) {
        MeterModel currentMeter=meterService.getMeterById(meterReading.getMeterModel().getMeterId()).get();
        List<WaterMeterMapping> sourceMeters=waterMeterMappingRepository.findByTarget(currentMeter);
        WaterMeterMapping sourceMeter=sourceMeters.get(0);
        MeterModel src=sourceMeter.getSource();
        System.out.println(src);
        int reading=meterReadingRepository.findById(src.getMeterId()).get().getMeterReading();
        System.out.println(reading);
        List<WaterMeterMapping>targetMeters=waterMeterMappingRepository.findBySource(src);
        int numberOfSourceMeters=targetMeters.size();
        return reading/numberOfSourceMeters;
////
////        System.out.println(sourceMeters);
////        System.out.println("source meter printed");
////        System.out.println(targetMeters);
////        System.out.println(numberOfSourceMeters);
////        return 1;
//
    }
    public List<MeterReading> addAllReading(List<MeterReading> payload) {
        List<MeterReading> meterReadings=new ArrayList<>();
        meterReadings.addAll(payload);
        payload.clear();
        System.out.println(meterReadings);
        System.out.println(meterReadings.size());
        int i=0;
        System.out.println(meterReadings.get(i).toString());
        System.out.println("abc");
        for( i=0;i<meterReadings.size();i++){
            System.out.println("Inside Loop");
            MeterReading meterReading=meterReadings.get(i);
            System.out.println("");
            MeterModel meterModel=meterService.getMeterById(meterReading.getMeterModel().getMeterId()).get();
            meterReading.setMeterModel(meterModel);
            meterReading.setExpectedVolume(calculateExpectedVolume(meterReading));
            meterReading.setPercentageLossOfWater(meterReading.getExpectedVolume()-meterReading.getMeterReading());
            LocalDateTime now=LocalDateTime.now();
            meterReading.setLocalDateTime(now);
            System.out.println("Loop 1st oiteration");
            payload.add(meterReading);
        }
        return meterReadingRepository.saveAll(payload);
    }
    public List<MeterReading> getAllReading(){
        return meterReadingRepository.findAll();
    }
}
