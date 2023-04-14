package com.demo.waterSupply.service;

import com.demo.waterSupply.dto.request.WaterMappingRequestDTO;
import com.demo.waterSupply.dto.respond.WaterMappingRespondDTO;
import com.demo.waterSupply.exception.EntityNotFoundException;
import com.demo.waterSupply.model.MeterModel;
import com.demo.waterSupply.model.WaterMeterMapping;
import com.demo.waterSupply.repository.MeterRepository;
import com.demo.waterSupply.repository.WaterMeterMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WaterMeterMappingService {
    @Autowired
    private WaterMeterMappingRepository waterMeterMappingRepository;
    @Autowired
    private MeterRepository meterRepository;
    public WaterMeterMapping addWaterMapping(WaterMappingRequestDTO waterMappingRequestDTO) {
        MeterModel source=meterRepository.findByMeterName(waterMappingRequestDTO.getSourceName());
        MeterModel target=meterRepository.findByMeterName(waterMappingRequestDTO.getTargetName());
        if(source==null||target==null)
            throw new EntityNotFoundException("Meter Doesn't Exist");
        WaterMeterMapping waterMeterMapping=new WaterMeterMapping();
        waterMeterMapping.setSource(source);
        waterMeterMapping.setTarget(target);
        return waterMeterMappingRepository.save(waterMeterMapping);
    }
    public WaterMappingRespondDTO getWaterMappingById(Long id){
        Optional<WaterMeterMapping> waterMeterMapping=waterMeterMappingRepository.findById(id);
        if(waterMeterMapping.isEmpty())
            throw new EntityNotFoundException("Mapping Doesn't Exist");
        WaterMappingRespondDTO waterMappingRespondDTO=new WaterMappingRespondDTO();
        waterMappingRespondDTO.setMappingId(waterMeterMapping.get().getMappingId());
        waterMappingRespondDTO.setSourceName(waterMeterMapping.get().getSource().getMeterName());
        waterMappingRespondDTO.setTargetName(waterMeterMapping.get().getTarget().getMeterName());
        return waterMappingRespondDTO;
    }
    public List<WaterMappingRespondDTO> getAllWaterMapping(){
        List<WaterMeterMapping> waterMeterMappings=waterMeterMappingRepository.findAll();
        if(waterMeterMappings.isEmpty())
            throw new EntityNotFoundException("No Mappings Present");
        List<WaterMappingRespondDTO> waterMappingRespondDTOS=new ArrayList<>();
        for(int i=0;i<waterMeterMappings.size();i++){
            WaterMappingRespondDTO waterMappingRespondDTO=new WaterMappingRespondDTO();
            waterMappingRespondDTO.setMappingId(waterMeterMappings.get(i).getMappingId());
            waterMappingRespondDTO.setSourceName(waterMeterMappings.get(i).getSource().getMeterName());
            waterMappingRespondDTO.setTargetName(waterMeterMappings.get(i).getTarget().getMeterName());
            waterMappingRespondDTOS.add(waterMappingRespondDTO);
        }
        return waterMappingRespondDTOS;
    }

    public WaterMeterMapping updateWaterMapping(WaterMappingRespondDTO waterMappingRespondDTO){
        System.out.println(waterMappingRespondDTO.getMappingId());
        WaterMeterMapping waterMeterMapping=waterMeterMappingRepository.findById(waterMappingRespondDTO.getMappingId()).get();
        MeterModel source=meterRepository.findByMeterName(waterMappingRespondDTO.getSourceName());
        MeterModel target=meterRepository.findByMeterName(waterMappingRespondDTO.getTargetName());
        if(source==null||target==null)
            throw new EntityNotFoundException("Meter Doesn't Exist");
        waterMeterMapping.setSource(source);
        waterMeterMapping.setTarget(target);
        return waterMeterMappingRepository.save(waterMeterMapping);
    }
    public void deleteWaterMappingById(Long id){
        Optional<WaterMeterMapping> waterMeterMapping=waterMeterMappingRepository.findById(id);
        if(waterMeterMapping.isEmpty())
            throw new EntityNotFoundException("Mapping Doesn't Exists");
        waterMeterMappingRepository.deleteById(id);
    }
}
