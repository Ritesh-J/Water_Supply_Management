package com.demo.waterSupply.service;

import com.demo.waterSupply.dto.request.CityRequestDTO;
import com.demo.waterSupply.dto.respond.CityRespondDTO;
import com.demo.waterSupply.exception.EntityExistsException;
import com.demo.waterSupply.exception.EntityNotFoundException;
import com.demo.waterSupply.model.CityModel;
import com.demo.waterSupply.model.UtilityModel;
import com.demo.waterSupply.repository.CityRepository;
import com.demo.waterSupply.repository.UtilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private UtilityRepository utilityRepository;
    public CityModel addCity(CityRequestDTO cityRequestDTO) {
        if(cityRepository.existsByCityName(cityRequestDTO.getCityName()))
            throw new EntityExistsException("City Already Exists");
        if(!utilityRepository.existsByUtilityName(cityRequestDTO.getUtilityName()))
            throw new EntityNotFoundException("Utility Does not Exist");
        UtilityModel utilityModel=utilityRepository.findByUtilityName(cityRequestDTO.getUtilityName());
        CityModel cityModel=new CityModel();
        cityModel.setCityName(cityRequestDTO.getCityName());
        cityModel.setUtilityModel(utilityModel);
        return cityRepository.save(cityModel);
    }
    public CityRespondDTO getCityById(Long cityId){
        Optional<CityModel> cityModel=cityRepository.findById(cityId);
        if(cityModel.isEmpty())
            throw new EntityNotFoundException("City with that ID Doesn't Exists");
        CityRespondDTO cityRespondDTO=new CityRespondDTO();
        cityRespondDTO.setCityId(cityModel.get().getCityId());
        cityRespondDTO.setCityName(cityModel.get().getCityName());
        cityRespondDTO.setUtilityName(cityModel.get().getUtilityModel().getUtilityName());
        return cityRespondDTO;
    }
    public List<CityRespondDTO> getAllCity(){
        List<CityRespondDTO> cityRespondDTOS=new ArrayList<>();
        List<CityModel> cityModels=cityRepository.findAll();
        if(cityModels.isEmpty())
            throw new EntityNotFoundException("No City Exists");
        for(int i=0;i<cityModels.size();i++){
            CityRespondDTO cityRespondDTO=new CityRespondDTO();
            cityRespondDTO.setCityId(cityModels.get(i).getCityId());
            cityRespondDTO.setCityName(cityModels.get(i).getCityName());
            cityRespondDTO.setUtilityName(cityModels.get(i).getUtilityModel().getUtilityName());
            cityRespondDTOS.add(cityRespondDTO);
        }
        return cityRespondDTOS;
    }


    public CityModel updateCity(CityRespondDTO cityRespondDTO) {
        CityModel cityModel=cityRepository.findById(cityRespondDTO.getCityId()).get();
        cityModel.setCityName(cityRespondDTO.getCityName());
        if(!utilityRepository.existsByUtilityName(cityRespondDTO.getUtilityName()))
            throw new EntityNotFoundException("Utility Doesn't Exist");
        UtilityModel utilityModel=utilityRepository.findByUtilityName(cityRespondDTO.getUtilityName());
        cityModel.setUtilityModel(utilityModel);
        return cityRepository.save(cityModel);
    }
    public void deleteCityById(Long id){
        Optional<CityModel> cityModel=cityRepository.findById(id);
        if(cityModel.isEmpty())
            throw new EntityNotFoundException("City By this id Doesn't Exist");
        cityRepository.deleteById(id);
    }
}
