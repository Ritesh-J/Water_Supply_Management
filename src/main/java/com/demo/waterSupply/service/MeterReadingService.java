package com.demo.waterSupply.service;

import com.demo.waterSupply.dto.request.MeterReadingRequestDTO;
import com.demo.waterSupply.dto.respond.MeterReadingRespondDTO;
import com.demo.waterSupply.dto.respond.MeterRespondDTO;
import com.demo.waterSupply.exception.EntityNotFoundException;
import com.demo.waterSupply.model.MeterModel;
import com.demo.waterSupply.model.MeterReading;
import com.demo.waterSupply.model.WaterMeterMapping;
import com.demo.waterSupply.repository.MeterReadingRepository;
import com.demo.waterSupply.repository.MeterRepository;
import com.demo.waterSupply.repository.WaterMeterMappingRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
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
    private MeterRepository meterRepository;
    @Autowired
    private WaterMeterMappingRepository waterMeterMappingRepository;
    public MeterReading addReading(MeterReadingRequestDTO meterReadingRequestDTO){
        MeterModel meterModel=meterRepository.findByMeterName(meterReadingRequestDTO.getMeterName());
        if(meterModel==null)
            throw new EntityNotFoundException("Meter Doesn't Exist");
        MeterReading meterReading=new MeterReading();
        meterReading.setMeterModel(meterModel);
        Integer reading=meterReadingRequestDTO.getMeterReading();
        meterReading.setMeterReading(reading);
        meterModel.setMeterReading(reading);
        if(meterReadingRequestDTO.getMeterName().equals("AA")){
            meterReading.setLocalDateTime(LocalDateTime.now());
            return meterReadingRepository.save(meterReading);
        }
        Integer expectedVolume=calculateExpectedVolume(meterModel,reading);
        meterReading.setExpectedVolume(expectedVolume);
        Integer lossOfWater=expectedVolume-reading;
        meterReading.setLossOfWater(lossOfWater);
        Double percentageLoss=Double.valueOf((lossOfWater*100)/expectedVolume);
        meterReading.setPercentageLoss(percentageLoss);
        meterReading.setLocalDateTime(LocalDateTime.now());
        return meterReadingRepository.save(meterReading);
    }
    public List<MeterReading> addAllReading(List<MeterReadingRequestDTO> meterReadingRequestDTOList){
        List<MeterReading> meterReadingList=new ArrayList<>();
        for(int i=0;i<meterReadingRequestDTOList.size();i++){
            MeterReading meterReading=new MeterReading();
            MeterModel meterModel=meterRepository.findByMeterName(meterReadingRequestDTOList.get(i).getMeterName());
            if(meterModel==null)
                throw new EntityNotFoundException("Meter Doesn't Exist");
            meterReading.setMeterModel(meterModel);
            Integer reading=meterReadingRequestDTOList.get(i).getMeterReading();
            meterReading.setMeterReading(reading);
            meterModel.setMeterReading(reading);
            if(meterReadingRequestDTOList.get(i).getMeterName().equals("AA")){
                meterReading.setLocalDateTime(LocalDateTime.now());
                meterReadingList.add(meterReading);
            }
            Integer expectedVolume=calculateExpectedVolume(meterModel,reading);
            meterReading.setExpectedVolume(expectedVolume);
            Integer lossOfWater=expectedVolume-reading;
            meterReading.setLossOfWater(lossOfWater);
            Double percentageLoss=Double.valueOf((lossOfWater*100)/expectedVolume);
            meterReading.setPercentageLoss(percentageLoss);
            meterReading.setLocalDateTime(LocalDateTime.now());
            meterReadingList.add(meterReading);
        }
        return meterReadingRepository.saveAll(meterReadingList);
    }
    public List<MeterReadingRespondDTO> getAllReading(){
        List<MeterReading> meterReadingList=meterReadingRepository.findAll();
        if(meterReadingList.isEmpty())
            throw new EntityNotFoundException("No Readings Available");
        List<MeterReadingRespondDTO> meterReadingRespondDTOList=new ArrayList<>();
        for(int i=0;i<meterReadingList.size();i++){
            MeterReadingRespondDTO meterReadingRespondDTO=new MeterReadingRespondDTO();
            meterReadingRespondDTO.setReadingId(meterReadingList.get(i).getReadingId());
            meterReadingRespondDTO.setMeterName(meterReadingList.get(i).getMeterModel().getMeterName());
            meterReadingRespondDTO.setMeterReading(meterReadingList.get(i).getMeterReading());
            meterReadingRespondDTO.setExpectedVolume(meterReadingList.get(i).getExpectedVolume());
            if(meterReadingList.get(i).getMeterModel().getMeterName()=="AA")
                meterReadingRespondDTO.setLossOfWater(0);
            else
                meterReadingRespondDTO.setLossOfWater(meterReadingList.get(i).getLossOfWater());
            meterReadingRespondDTO.setPercentageLoss(meterReadingList.get(i).getPercentageLoss());
            meterReadingRespondDTO.setLocalDateTime(meterReadingList.get(i).getLocalDateTime());
            meterReadingRespondDTOList.add(meterReadingRespondDTO);
        }
        return meterReadingRespondDTOList;
    }
    public MeterReadingRespondDTO getReadingById(Long id){
        Optional<MeterReading> meterReading=meterReadingRepository.findById(id);
        if(meterReading.isEmpty())
            throw new EntityNotFoundException("Meter By This ID Doesn't Exist");
        MeterReadingRespondDTO meterReadingRespondDTO=new MeterReadingRespondDTO();
        meterReadingRespondDTO.setReadingId(meterReading.get().getReadingId());
        meterReadingRespondDTO.setMeterReading(meterReading.get().getMeterReading());
        meterReadingRespondDTO.setMeterName(meterReading.get().getMeterModel().getMeterName());
        meterReadingRespondDTO.setExpectedVolume(meterReading.get().getExpectedVolume());
        if(meterReading.get().getMeterModel().getMeterName()=="AA")
            meterReadingRespondDTO.setLossOfWater(0);
        else
            meterReadingRespondDTO.setLossOfWater(meterReading.get().getLossOfWater());
        meterReadingRespondDTO.setPercentageLoss(meterReading.get().getPercentageLoss());
        meterReadingRespondDTO.setLocalDateTime(meterReading.get().getLocalDateTime());
        return meterReadingRespondDTO;

    }
    public void deleteMeterReadingById(Long id){
        Optional<MeterReading> meterReading=meterReadingRepository.findById(id);
        if(meterReading.isEmpty())
            throw new EntityNotFoundException("Reading not Found");
        meterReadingRepository.deleteById(id);
    }
    public Integer calculateExpectedVolume(MeterModel meterModel, Integer meterReading){
        MeterModel meterModel1=meterRepository.findByMeterName(meterModel.getMeterName());
        List<String> sourceMeters=findSourceMeters(meterModel1);
        Integer expectedVolume=0;
        for(int i=0;i<sourceMeters.size();i++){
            String sourceName=sourceMeters.get(i);
            System.out.println(sourceName);
            MeterModel sourceMeter=meterRepository.findByMeterName(sourceName);
            System.out.println(sourceMeter);
            Integer reading=sourceMeter.getMeterReading();
            System.out.println(reading);
//            System.out.println(meterReadingRepository.findByMeterId(sourceMeter.getMeterId()));
            Integer numberOfTarget=numberOfTargets(sourceMeter);
            System.out.println(numberOfTarget);
            expectedVolume+=reading/numberOfTarget;
        }
        System.out.println(expectedVolume);
        System.out.println(sourceMeters);
        System.out.println(meterModel);
        System.out.println(meterReading);
        return expectedVolume;
    }

    public Integer numberOfTargets(MeterModel meterModel){
        List<WaterMeterMapping> targets=waterMeterMappingRepository.findBySource(meterModel);
        return targets.size();
    }
    public  Integer findMeterReading(MeterModel sourceMeter){
        Optional<MeterReading> meterReading=meterReadingRepository.findById(sourceMeter.getMeterId());
        Integer reading=meterReading.get().getMeterReading();
        return reading;
    }

    public List<String> findSourceMeters(MeterModel meterModel) {
        if (meterModel.getMeterName() == "AA")
            return null;
        List<WaterMeterMapping> sourceMeters = waterMeterMappingRepository.findByTarget(meterModel);
        List<String> sourceMeterNames = new ArrayList<>();
        for (int i = 0; i < sourceMeters.size(); i++) {
            String sourceMeterName = sourceMeters.get(i).getSource().getMeterName();
            sourceMeterNames.add(sourceMeterName);
        }
        return sourceMeterNames;

    }
}
