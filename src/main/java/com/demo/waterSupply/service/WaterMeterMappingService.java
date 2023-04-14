//package com.demo.waterSupply.service;
//
//import com.demo.waterSupply.model.MeterModel;
//import com.demo.waterSupply.model.WaterMeterMapping;
//import com.demo.waterSupply.repository.MeterRepository;
//import com.demo.waterSupply.repository.WaterMeterMappingRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class WaterMeterMappingService {
//    @Autowired
//    private WaterMeterMappingRepository waterMeterMappingRepository;
//    @Autowired
//    private MeterService meterService;
//    @Autowired
//    private MeterRepository meterRepository;
//    public WaterMeterMapping addWaterMapping(WaterMeterMapping mapping) {
//        MeterModel source=meterService.getMeterById(mapping.getSource().getMeterId()).get();
//        mapping.setSource(source);
//        MeterModel target=meterService.getMeterById(mapping.getTarget().getMeterId()).get();
//        mapping.setTarget(target);
//        return waterMeterMappingRepository.save(mapping);
//    }
//    public Optional<WaterMeterMapping> getWaterMeterMappingById(Long id){
//        return waterMeterMappingRepository.findById(id);
//    }
//
//    public List<WaterMeterMapping> getWaterMappings() {
//        return waterMeterMappingRepository.findAll();
//    }
//}
