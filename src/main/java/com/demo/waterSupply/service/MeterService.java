package com.demo.waterSupply.service;

import com.demo.waterSupply.dto.request.MeterRequestDTO;
import com.demo.waterSupply.dto.respond.MeterRespondDTO;
import com.demo.waterSupply.exception.EntityExistsException;
import com.demo.waterSupply.exception.EntityNotFoundException;
import com.demo.waterSupply.model.CityModel;
import com.demo.waterSupply.model.MeterModel;
import com.demo.waterSupply.repository.CityRepository;
import com.demo.waterSupply.repository.MeterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MeterService {
    @Autowired
    private MeterRepository meterRepository;
    @Autowired
    private CityRepository cityRepository;
    public MeterModel addMeter(MeterRequestDTO meterRequestDTO) {
        MeterModel meterModel=new MeterModel();
        if(meterRepository.existsByMeterName(meterRequestDTO.getMeterName()))
            throw new EntityExistsException("Meter Already Exists");
        if(!cityRepository.existsByCityName(meterRequestDTO.getCityName()))
            throw new EntityNotFoundException("City Doesn't Exists");
        CityModel cityModel=cityRepository.findByCityName(meterRequestDTO.getCityName());
        meterModel.setMeterName(meterRequestDTO.getMeterName());
        meterModel.setCriticalVolume(meterRequestDTO.getCriticalVolume());
        meterModel.setCrossSecArea(meterRequestDTO.getCrossSecArea());
        meterModel.setLocationPin(meterRequestDTO.getLocationPin());
        meterModel.setCityModel(cityModel);
        return meterRepository.save(meterModel);
    }
    public MeterRespondDTO getMeterById(Long id){
        Optional<MeterModel> meterModel=meterRepository.findById(id);
        if(meterModel.isEmpty())
            throw new EntityNotFoundException("Meter Doesn't Exists");
        MeterRespondDTO meterRespondDTO=new MeterRespondDTO();
        meterRespondDTO.setMeterId(meterModel.get().getMeterId());
        meterRespondDTO.setMeterName(meterModel.get().getMeterName());
        meterRespondDTO.setCriticalVolume(meterModel.get().getCriticalVolume());
        meterRespondDTO.setLocationPin(meterModel.get().getLocationPin());
        meterRespondDTO.setCrossSecArea(meterModel.get().getCrossSecArea());
        meterRespondDTO.setCityName(meterModel.get().getCityModel().getCityName());
        return meterRespondDTO;
    }
    public List<MeterRespondDTO> getAllMeter(){
        List<MeterModel> meterModels=meterRepository.findAll();
        if(meterModels.isEmpty())
            throw new EntityNotFoundException("Meters Doesn't Exists");
        List<MeterRespondDTO> meterRespondDTOS=new ArrayList<>();
        for(int i=0;i<meterModels.size();i++){
            MeterRespondDTO meterRespondDTO=new MeterRespondDTO();
            meterRespondDTO.setMeterId(meterModels.get(i).getMeterId());
            meterRespondDTO.setMeterName(meterModels.get(i).getMeterName());
            meterRespondDTO.setCrossSecArea(meterModels.get(i).getCrossSecArea());
            meterRespondDTO.setLocationPin(meterModels.get(i).getLocationPin());
            meterRespondDTO.setCriticalVolume(meterModels.get(i).getCriticalVolume());
            meterRespondDTO.setCityName(meterModels.get(i).getCityModel().getCityName());
            meterRespondDTOS.add(meterRespondDTO);
        }
        return meterRespondDTOS;
    }
    public MeterModel updateMeter(MeterRespondDTO meterRespondDTO){
        MeterModel meterModel=meterRepository.findById(meterRespondDTO.getMeterId()).get();
        if(!cityRepository.existsByCityName(meterRespondDTO.getCityName()))
            throw new EntityNotFoundException("City Doesn't Exists");
        CityModel cityModel=cityRepository.findByCityName(meterRespondDTO.getCityName());
        meterModel.setMeterName(meterRespondDTO.getMeterName());
        meterModel.setCrossSecArea(meterRespondDTO.getCrossSecArea());
        meterModel.setCriticalVolume(meterRespondDTO.getCriticalVolume());
        meterModel.setLocationPin(meterRespondDTO.getLocationPin());
        meterModel.setCityModel(cityModel);
        return meterRepository.save(meterModel);
    }
    public void deleteById(Long id){
        Optional<MeterModel> meterModel=meterRepository.findById(id);
        if(meterModel.isEmpty())
            throw new EntityNotFoundException("Meter Doesn't Exists");
        meterRepository.deleteById(id);
    }
}
